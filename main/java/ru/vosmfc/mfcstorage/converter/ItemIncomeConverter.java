package ru.vosmfc.mfcstorage.converter;

import org.springframework.stereotype.Component;
import ru.vosmfc.mfcstorage.domain.ItemIncome;
import ru.vosmfc.mfcstorage.dto.ItemIncomeDto;

import java.time.LocalDate;

@Component
public class ItemIncomeConverter {

    public ItemIncome fromItemIncomeDtoToItemIncome(ItemIncomeDto itemIncomeDto) {
        return new ItemIncome(
                itemIncomeDto.getStorage(),
                itemIncomeDto.getIncomeQuantity(),
                LocalDate.parse(itemIncomeDto.getIncomeDate())
        );
    }

    public ItemIncomeDto fromItemIncomeToItemIncomeDto(ItemIncome itemIncome) {
        return new ItemIncomeDto(
                itemIncome.getId(),
                itemIncome.getStorage(),
                itemIncome.getIncomeQuantity(),
                itemIncome.getIncomeDate().toString()
        );
    }

}
