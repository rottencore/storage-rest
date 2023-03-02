package ru.vosmfc.mfcstorage.converter;

import org.springframework.stereotype.Component;
import ru.vosmfc.mfcstorage.domain.ItemCategory;
import ru.vosmfc.mfcstorage.dto.ItemCategoryDto;

@Component
public class ItemCategoryConverter {

    public ItemCategory fromItemCategoryDtoToItemCategory(ItemCategoryDto itemCategoryDto) {
        return new ItemCategory(itemCategoryDto.getCategoryName());
    }

    public ItemCategoryDto fromItemCategoryToItemCategoryDto(ItemCategory itemCategory) {
        return new ItemCategoryDto(itemCategory.getId(), itemCategory.getCategoryName());
    }

}
