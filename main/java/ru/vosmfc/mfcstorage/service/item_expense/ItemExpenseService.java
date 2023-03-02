package ru.vosmfc.mfcstorage.service.item_expense;

import ru.vosmfc.mfcstorage.dto.ItemExpenseDto;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.exception.QuantityException;

import java.util.List;

public interface ItemExpenseService {

    void saveItemExpense(ItemExpenseDto itemExpenseDto) throws QuantityException, ObjectNotFoundException;

    void deleteItemExpense(Long id) throws ObjectNotFoundException;

    ItemExpenseDto findItemExpenseById(Long id) throws ObjectNotFoundException;

    List<ItemExpenseDto> findAllItemExpenses();

}
