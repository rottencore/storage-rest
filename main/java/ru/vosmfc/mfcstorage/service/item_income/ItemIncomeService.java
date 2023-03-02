package ru.vosmfc.mfcstorage.service.item_income;

import ru.vosmfc.mfcstorage.dto.ItemIncomeDto;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.exception.QuantityException;

import java.util.List;

public interface ItemIncomeService {

    void saveItemIncome(ItemIncomeDto itemIncomeDto) throws ObjectNotFoundException;

    void deleteItemIncome(Long id) throws ObjectNotFoundException, QuantityException;

    ItemIncomeDto findItemIncomeById(Long id) throws ObjectNotFoundException;

    List<ItemIncomeDto> findAllItemIncomes();

}
