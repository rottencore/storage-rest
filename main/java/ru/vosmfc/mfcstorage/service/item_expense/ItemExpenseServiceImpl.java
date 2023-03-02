package ru.vosmfc.mfcstorage.service.item_expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vosmfc.mfcstorage.converter.ItemExpenseConverter;
import ru.vosmfc.mfcstorage.domain.ItemExpense;
import ru.vosmfc.mfcstorage.domain.Storage;
import ru.vosmfc.mfcstorage.dto.ItemExpenseDto;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.exception.QuantityException;
import ru.vosmfc.mfcstorage.repository.ItemExpenseRepository;
import ru.vosmfc.mfcstorage.repository.StorageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemExpenseServiceImpl implements ItemExpenseService {

    @Autowired
    private final ItemExpenseRepository itemExpenseRepository;

    @Autowired
    private final StorageRepository storageRepository;

    @Autowired
    private final ItemExpenseConverter itemExpenseConverter;

    public ItemExpenseServiceImpl(ItemExpenseRepository itemExpenseRepository,
                                  StorageRepository storageRepository,
                                  ItemExpenseConverter itemExpenseConverter) {
        this.itemExpenseRepository = itemExpenseRepository;
        this.storageRepository = storageRepository;
        this.itemExpenseConverter = itemExpenseConverter;
    }

    @Override
    public void saveItemExpense(ItemExpenseDto itemExpenseDto) throws QuantityException, ObjectNotFoundException {
        ItemExpense itemExpense = itemExpenseConverter.fromItemExpenseDtoToItemExpense(itemExpenseDto);
        Storage storage = storageRepository.findById(itemExpense.getStorage().getId())
                .orElseThrow(() -> new ObjectNotFoundException("Storage with id " + itemExpense.getStorage().getId() + " not found."));

        if (storage.getQuantity() < itemExpense.getExpenseQuantity()) {
            throw new QuantityException("Quantity in storage less than need to expense.");
        }

        storage.setQuantity(storage.getQuantity() - itemExpense.getExpenseQuantity());
        storageRepository.save(storage);
        itemExpenseRepository.save(itemExpense);
    }

    @Override
    public void deleteItemExpense(Long id) throws ObjectNotFoundException {
        ItemExpense itemExpense = itemExpenseRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Item Expense with id " + id + " not found."));

        Storage storage = storageRepository.findById(itemExpense.getStorage().getId())
                .orElseThrow(() -> new ObjectNotFoundException("Storage with id " + id + " not found"));

        storage.setQuantity(storage.getQuantity() + itemExpense.getExpenseQuantity());
        storageRepository.save(storage);
        itemExpenseRepository.deleteById(id);
    }

    @Override
    public ItemExpenseDto findItemExpenseById(Long id) throws ObjectNotFoundException {
        ItemExpense itemExpense = itemExpenseRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Item expense with " + id + " not found."));

        return itemExpenseConverter.fromItemExpenseToItemExpenseDto(itemExpense);
    }

    @Override
    public List<ItemExpenseDto> findAllItemExpenses() {
        List<ItemExpenseDto> itemExpenseDtoList = new ArrayList<>();
        List<ItemExpense> itemExpenses = itemExpenseRepository.findAll();

        for (ItemExpense itemExpense : itemExpenses) {
            itemExpenseDtoList.add(itemExpenseConverter.fromItemExpenseToItemExpenseDto(itemExpense));
        }

        return itemExpenseDtoList;
    }

}
