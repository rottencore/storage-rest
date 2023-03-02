package ru.vosmfc.mfcstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vosmfc.mfcstorage.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
