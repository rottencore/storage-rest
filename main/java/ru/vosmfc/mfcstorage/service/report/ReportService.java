package ru.vosmfc.mfcstorage.service.report;

import ru.vosmfc.mfcstorage.dto.ItemExpenseDto;
import ru.vosmfc.mfcstorage.dto.ItemIncomeDto;
import ru.vosmfc.mfcstorage.dto.StorageDto;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    List<ItemExpenseDto> findItemExpenseBetweenDate(LocalDate startDate, LocalDate endDate);

    List<ItemIncomeDto> findItemIncomeBetweenDate(LocalDate startDate, LocalDate endDate);

    StorageDto findStorageByItemName(String itemName);

    List<ItemExpenseDto> findItemExpenseByStorageItemItemName(String itemName);

    List<ItemIncomeDto> findItemIncomeByStorageItemItemName(String itemName);

}
