package ru.vosmfc.mfcstorage.service.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vosmfc.mfcstorage.converter.ItemExpenseConverter;
import ru.vosmfc.mfcstorage.converter.ItemIncomeConverter;
import ru.vosmfc.mfcstorage.converter.StorageConverter;
import ru.vosmfc.mfcstorage.domain.ItemExpense;
import ru.vosmfc.mfcstorage.domain.ItemIncome;
import ru.vosmfc.mfcstorage.domain.Storage;
import ru.vosmfc.mfcstorage.dto.ItemExpenseDto;
import ru.vosmfc.mfcstorage.dto.ItemIncomeDto;
import ru.vosmfc.mfcstorage.dto.StorageDto;
import ru.vosmfc.mfcstorage.repository.ItemExpenseRepository;
import ru.vosmfc.mfcstorage.repository.ItemIncomeRepository;
import ru.vosmfc.mfcstorage.repository.StorageRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private final ItemExpenseRepository itemExpenseRepository;

    @Autowired
    private final ItemIncomeRepository itemIncomeRepository;

    @Autowired
    private final StorageRepository storageRepository;

    @Autowired
    private final StorageConverter storageConverter;

    @Autowired
    private final ItemExpenseConverter itemExpenseConverter;

    @Autowired
    private final ItemIncomeConverter itemIncomeConverter;

    public ReportServiceImpl(ItemExpenseRepository itemExpenseRepository,
                             ItemIncomeRepository itemIncomeRepository,
                             StorageRepository storageRepository,
                             ItemExpenseConverter itemExpenseConverter,
                             ItemIncomeConverter itemIncomeConverter,
                             StorageConverter storageConverter) {
        this.itemExpenseRepository = itemExpenseRepository;
        this.itemIncomeRepository = itemIncomeRepository;
        this.storageRepository = storageRepository;
        this.itemExpenseConverter = itemExpenseConverter;
        this.itemIncomeConverter = itemIncomeConverter;
        this.storageConverter = storageConverter;
    }

    @Override
    public List<ItemExpenseDto> findItemExpenseBetweenDate(LocalDate startDate, LocalDate endDate) {
        List<ItemExpenseDto> itemExpenseDtoList = new ArrayList<>();
        List<ItemExpense> itemExpenses = itemExpenseRepository.findItemExpenseByExpenseDateBetween(startDate, endDate);

        for (ItemExpense itemExpense : itemExpenses) {
            itemExpenseDtoList.add(itemExpenseConverter.fromItemExpenseToItemExpenseDto(itemExpense));
        }

        return itemExpenseDtoList;
    }

    @Override
    public List<ItemIncomeDto> findItemIncomeBetweenDate(LocalDate startDate, LocalDate endDate) {
        List<ItemIncomeDto> itemIncomeDtoList = new ArrayList<>();
        List<ItemIncome> itemIncomes = itemIncomeRepository.findItemIncomeByIncomeDateBetween(startDate, endDate);

        for (ItemIncome itemIncome : itemIncomes) {
            itemIncomeDtoList.add(itemIncomeConverter.fromItemIncomeToItemIncomeDto(itemIncome));
        }

        return itemIncomeDtoList;
    }

    @Override
    public StorageDto findStorageByItemName(String itemName) {
        Storage storage = storageRepository.findStorageByItemItemName(itemName);
        return storageConverter.fromStorageToStorageDto(storage);
    }

    @Override
    public List<ItemExpenseDto> findItemExpenseByStorageItemItemName(String itemName) {
        List<ItemExpenseDto> itemExpenseDtoList = new ArrayList<>();
        List<ItemExpense> itemExpenses = itemExpenseRepository.findItemExpenseByStorageItemItemName(itemName);

        for (ItemExpense itemExpense : itemExpenses) {
            itemExpenseDtoList.add(itemExpenseConverter.fromItemExpenseToItemExpenseDto(itemExpense));
        }

        return itemExpenseDtoList;
    }

    @Override
    public List<ItemIncomeDto> findItemIncomeByStorageItemItemName(String itemName) {
        List<ItemIncomeDto> itemIncomeDtoList = new ArrayList<>();
        List<ItemIncome> itemIncomes = itemIncomeRepository.findItemIncomeByStorageItemItemName(itemName);

        for (ItemIncome itemIncome : itemIncomes) {
            itemIncomeDtoList.add(itemIncomeConverter.fromItemIncomeToItemIncomeDto(itemIncome));
        }

        return itemIncomeDtoList;
    }

}
