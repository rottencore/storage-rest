package ru.vosmfc.mfcstorage.converter;

import org.springframework.stereotype.Component;
import ru.vosmfc.mfcstorage.domain.Storage;
import ru.vosmfc.mfcstorage.dto.StorageDto;

@Component
public class StorageConverter {

    public Storage fromStorageDtoToStorage(StorageDto storageDto) {
        return new Storage(storageDto.getItem(), storageDto.getQuantity());
    }

    public StorageDto fromStorageToStorageDto(Storage storage) {
        return new StorageDto(storage.getId(), storage.getItem(), storage.getQuantity());
    }

}
