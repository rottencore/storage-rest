package ru.vosmfc.mfcstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vosmfc.mfcstorage.domain.ItemIncome;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemIncomeRepository extends JpaRepository<ItemIncome, Long> {

    List<ItemIncome> findItemIncomeByIncomeDateBetween(LocalDate startDate, LocalDate endDate);

    List<ItemIncome> findItemIncomeByStorageItemItemName(String itemName);

}
