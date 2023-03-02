package ru.vosmfc.mfcstorage.service.storage;

import ru.vosmfc.mfcstorage.dto.StorageDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.exception.QuantityException;

import java.util.List;

public interface StorageService {

    void saveStorage(StorageDto storageDto) throws ObjectAlreadyExistException;

    void updateStorageItemQuantity(Long id, StorageDto storageDto) throws ObjectAlreadyExistException, ObjectNotFoundException, QuantityException;

    StorageDto getStorageById(Long id) throws ObjectNotFoundException;

    List<StorageDto> findAllStorages();

}
