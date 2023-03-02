package ru.vosmfc.mfcstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vosmfc.mfcstorage.domain.ItemCategory;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
}
