package ru.vosmfc.mfcstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vosmfc.mfcstorage.domain.ItemExpense;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemExpenseRepository extends JpaRepository<ItemExpense, Long> {

    List<ItemExpense> findItemExpenseByExpenseDateBetween(LocalDate startDate, LocalDate endDate);

    List<ItemExpense> findItemExpenseByStorageItemItemName(String itemName);

}
