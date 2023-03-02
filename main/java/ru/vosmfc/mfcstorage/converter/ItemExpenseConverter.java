package ru.vosmfc.mfcstorage.converter;

import org.springframework.stereotype.Component;
import ru.vosmfc.mfcstorage.domain.ItemExpense;
import ru.vosmfc.mfcstorage.dto.ItemExpenseDto;

import java.time.LocalDate;

@Component
public class ItemExpenseConverter {

    public ItemExpense fromItemExpenseDtoToItemExpense(ItemExpenseDto itemExpenseDto) {
        return new ItemExpense(
                itemExpenseDto.getStorage(),
                itemExpenseDto.getRecipient(),
                itemExpenseDto.getExpenseQuantity(),
                LocalDate.parse(itemExpenseDto.getExpenseDate())
        );
    }

    public ItemExpenseDto fromItemExpenseToItemExpenseDto(ItemExpense itemExpense) {
        return new ItemExpenseDto(
                itemExpense.getId(),
                itemExpense.getStorage(),
                itemExpense.getRecipient(),
                itemExpense.getExpenseQuantity(),
                itemExpense.getExpenseDate().toString()
        );
    }

}
