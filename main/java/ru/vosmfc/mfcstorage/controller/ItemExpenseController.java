package ru.vosmfc.mfcstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vosmfc.mfcstorage.converter.ItemExpenseConverter;
import ru.vosmfc.mfcstorage.dto.ItemExpenseDto;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.exception.QuantityException;
import ru.vosmfc.mfcstorage.service.item_expense.ItemExpenseService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/item_expenses")
public class ItemExpenseController {

    @Autowired
    private final ItemExpenseService itemExpenseService;

    public ItemExpenseController(ItemExpenseService itemExpenseService) {
        this.itemExpenseService = itemExpenseService;
    }

    @PostMapping
    public ResponseEntity<Void> saveItemExpense(@Valid @RequestBody ItemExpenseDto itemExpenseDto)
            throws ObjectNotFoundException, QuantityException {
        itemExpenseService.saveItemExpense(itemExpenseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteItemExpense(@PathVariable(name = "id") Long id) throws ObjectNotFoundException {
        itemExpenseService.deleteItemExpense(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ItemExpenseDto> findItemExpenseById(@PathVariable(name = "id") Long id) throws ObjectNotFoundException {
        return new ResponseEntity<>(itemExpenseService.findItemExpenseById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemExpenseDto>> findAllItemExpenses() {
        return new ResponseEntity<>(itemExpenseService.findAllItemExpenses(), HttpStatus.OK);
    }

}
