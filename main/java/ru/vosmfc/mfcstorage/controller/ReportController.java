package ru.vosmfc.mfcstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vosmfc.mfcstorage.dto.ItemExpenseDto;
import ru.vosmfc.mfcstorage.dto.ItemIncomeDto;
import ru.vosmfc.mfcstorage.dto.StorageDto;
import ru.vosmfc.mfcstorage.dto.report_dto.FindItemExpenseBetweenDateDto;
import ru.vosmfc.mfcstorage.dto.report_dto.FindItemIncomeBetweenDateDto;
import ru.vosmfc.mfcstorage.dto.report_dto.FindByItemNameDto;
import ru.vosmfc.mfcstorage.service.report.ReportService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/reports")
public class ReportController {

    @Autowired
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(path = "/item_expense_between_date")
    public ResponseEntity<List<ItemExpenseDto>> findItemExpenseBetweenDate(@Valid @RequestBody FindItemExpenseBetweenDateDto findItemExpenseBetweenDateDto) {
        List<ItemExpenseDto> itemExpenseDtoList = reportService.findItemExpenseBetweenDate(
                LocalDate.parse(findItemExpenseBetweenDateDto.getStartDate()),
                LocalDate.parse(findItemExpenseBetweenDateDto.getEndDate())
        );

        return new ResponseEntity<>(itemExpenseDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/item_income_between_date")
    public ResponseEntity<List<ItemIncomeDto>> findItemIncomeBetweenDate(@Valid @RequestBody FindItemIncomeBetweenDateDto findItemIncomeBetweenDateDto) {
        List<ItemIncomeDto> itemIncomeDtoList = reportService.findItemIncomeBetweenDate(
                LocalDate.parse(findItemIncomeBetweenDateDto.getStartDate()),
                LocalDate.parse(findItemIncomeBetweenDateDto.getEndDate())
        );

        return new ResponseEntity<>(itemIncomeDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/storage_by_item_name")
    public ResponseEntity<StorageDto> findStorageByItemName(@Valid @RequestBody FindByItemNameDto findByItemNameDto) {
        return new ResponseEntity<>(reportService.findStorageByItemName(findByItemNameDto.getItemName()), HttpStatus.OK);
    }

    @GetMapping(path = "/item_expense_by_item_name")
    public ResponseEntity<List<ItemExpenseDto>> findItemExpenseByStorageByItemItemName(@Valid @RequestBody FindByItemNameDto findByItemNameDto) {
        return new ResponseEntity<>(reportService.findItemExpenseByStorageItemItemName(findByItemNameDto.getItemName()), HttpStatus.OK);
    }

    @GetMapping(path = "/item_income_by_item_name")
    public ResponseEntity<List<ItemIncomeDto>> findItemIncomeByStorageItemItemName(@Valid @RequestBody FindByItemNameDto findByItemNameDto) {
        return new ResponseEntity<>(reportService.findItemIncomeByStorageItemItemName(findByItemNameDto.getItemName()), HttpStatus.OK);
    }

}
