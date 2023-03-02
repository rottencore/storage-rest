package ru.vosmfc.mfcstorage.service.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vosmfc.mfcstorage.converter.StorageConverter;
import ru.vosmfc.mfcstorage.domain.Item;
import ru.vosmfc.mfcstorage.domain.Storage;
import ru.vosmfc.mfcstorage.dto.StorageDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.exception.QuantityException;
import ru.vosmfc.mfcstorage.repository.ItemRepository;
import ru.vosmfc.mfcstorage.repository.StorageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private final ItemRepository itemRepository;

    @Autowired
    private final StorageRepository storageRepository;

    @Autowired
    private final StorageConverter storageConverter;

    public StorageServiceImpl(ItemRepository itemRepository,
                              StorageRepository storageRepository,
                              StorageConverter storageConverter) {
        this.itemRepository = itemRepository;
        this.storageRepository = storageRepository;
        this.storageConverter = storageConverter;
    }

    @Override
    public void saveStorage(StorageDto storageDto) throws ObjectAlreadyExistException {
        Storage storage = storageConverter.fromStorageDtoToStorage(storageDto);

        try {
            storageRepository.save(storage);
        } catch (Exception exception) {
            throw new ObjectAlreadyExistException("Storage with item " + storageDto.getItem().getItemName() + " already exist.");
        }
    }

    @Override
    public void updateStorageItemQuantity(Long id, StorageDto storageDto)
            throws ObjectAlreadyExistException, ObjectNotFoundException, QuantityException {
        Storage storage = storageRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Storage with id " + id + " not found."));

        if (storageDto.getQuantity() < 0) {
            throw new QuantityException("Quantity cannot be less than zero.");
        }

        storage.setQuantity(storageDto.getQuantity());

        try {
            storageRepository.save(storage);
        } catch (Exception exception) {
            throw new ObjectAlreadyExistException("Storage with item " + storageDto.getItem().getItemName() + " already exist.");
        }
    }

    @Override
    public StorageDto getStorageById(Long id) throws ObjectNotFoundException {
        Storage storage = storageRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Storage with id " + id + " not found"));

        return storageConverter.fromStorageToStorageDto(storage);
    }

    @Override
    public List<StorageDto> findAllStorages() {
        List<StorageDto> storageDtoList = new ArrayList<>();
        List<Storage> storages = storageRepository.findAll();

        for (Storage storage : storages) {
            storageDtoList.add(storageConverter.fromStorageToStorageDto(storage));
        }

        return storageDtoList;
    }

}
