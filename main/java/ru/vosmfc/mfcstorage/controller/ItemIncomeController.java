package ru.vosmfc.mfcstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vosmfc.mfcstorage.dto.ItemIncomeDto;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.exception.QuantityException;
import ru.vosmfc.mfcstorage.service.item_income.ItemIncomeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/item_incomes")
public class ItemIncomeController {

    @Autowired
    private final ItemIncomeService itemIncomeService;

    public ItemIncomeController(ItemIncomeService itemIncomeService) {
        this.itemIncomeService = itemIncomeService;
    }

    @PostMapping
    public ResponseEntity<Void> saveItemIncome(@Valid @RequestBody ItemIncomeDto itemIncomeDto) throws ObjectNotFoundException {
        itemIncomeService.saveItemIncome(itemIncomeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteItemIncome(@PathVariable(name = "id") Long id) throws ObjectNotFoundException, QuantityException {
        itemIncomeService.deleteItemIncome(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ItemIncomeDto> findItemIncomeById(@PathVariable(name = "id") Long id) throws ObjectNotFoundException {
        return new ResponseEntity<>(itemIncomeService.findItemIncomeById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemIncomeDto>> findAllItemIncomes() {
        return new ResponseEntity<>(itemIncomeService.findAllItemIncomes(), HttpStatus.OK);
    }

}
