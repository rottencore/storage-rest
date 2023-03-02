package ru.vosmfc.mfcstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vosmfc.mfcstorage.domain.Storage;

public interface StorageRepository extends JpaRepository<Storage, Long> {

    Storage findStorageByItemItemName(String itemName);

}
