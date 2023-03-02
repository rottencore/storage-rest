package ru.vosmfc.mfcstorage.service.item_income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vosmfc.mfcstorage.converter.ItemIncomeConverter;
import ru.vosmfc.mfcstorage.domain.ItemIncome;
import ru.vosmfc.mfcstorage.domain.Storage;
import ru.vosmfc.mfcstorage.dto.ItemIncomeDto;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.exception.QuantityException;
import ru.vosmfc.mfcstorage.repository.ItemIncomeRepository;
import ru.vosmfc.mfcstorage.repository.StorageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemIncomeServiceImpl implements ItemIncomeService {

    @Autowired
    private final ItemIncomeRepository itemIncomeRepository;

    @Autowired
    private final StorageRepository storageRepository;

    @Autowired
    private final ItemIncomeConverter itemIncomeConverter;

    public ItemIncomeServiceImpl(ItemIncomeRepository itemIncomeRepository, StorageRepository storageRepository, ItemIncomeConverter itemIncomeConverter) {
        this.itemIncomeRepository = itemIncomeRepository;
        this.storageRepository = storageRepository;
        this.itemIncomeConverter = itemIncomeConverter;
    }

    @Override
    public void saveItemIncome(ItemIncomeDto itemIncomeDto) throws ObjectNotFoundException {
        ItemIncome itemIncome = itemIncomeConverter.fromItemIncomeDtoToItemIncome(itemIncomeDto);
        Storage storage = storageRepository.findById(itemIncome.getStorage().getId())
                .orElseThrow(() -> new ObjectNotFoundException("Storage with id " + itemIncome.getStorage().getId() + " not found."));

        storage.setQuantity(storage.getQuantity() + itemIncome.getIncomeQuantity());
        storageRepository.save(storage);
        itemIncomeRepository.save(itemIncome);
    }

    @Override
    public void deleteItemIncome(Long id) throws ObjectNotFoundException, QuantityException {
        ItemIncome itemIncome = itemIncomeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Item income with id " + id + " not found."));

        Storage storage = storageRepository.findById(itemIncome.getStorage().getId())
                .orElseThrow(() -> new ObjectNotFoundException("Storage with id " + itemIncome.getStorage().getId() + " not found."));

        if (storage.getQuantity() < itemIncome.getIncomeQuantity()) {
            throw new QuantityException("Quantity less than storage quantity");
        }

        storage.setQuantity(storage.getQuantity() - itemIncome.getIncomeQuantity());
        storageRepository.save(storage);
        itemIncomeRepository.deleteById(id);
    }

    @Override
    public ItemIncomeDto findItemIncomeById(Long id) throws ObjectNotFoundException {
        ItemIncome itemIncome = itemIncomeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Item income with id " + id + " not found."));

        return itemIncomeConverter.fromItemIncomeToItemIncomeDto(itemIncome);
    }

    @Override
    public List<ItemIncomeDto> findAllItemIncomes() {
        List<ItemIncomeDto> itemIncomeDtoList = new ArrayList<>();
        List<ItemIncome> itemIncomes = itemIncomeRepository.findAll();

        for (ItemIncome itemIncome : itemIncomes) {
            itemIncomeDtoList.add(itemIncomeConverter.fromItemIncomeToItemIncomeDto(itemIncome));
        }

        return itemIncomeDtoList;
    }

}
