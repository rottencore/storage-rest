package ru.vosmfc.mfcstorage.service.item_category;

import ru.vosmfc.mfcstorage.dto.ItemCategoryDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;

import java.util.List;

public interface ItemCategoryService {

    void saveItemCategory(ItemCategoryDto itemCategoryDto) throws ObjectAlreadyExistException;

    List<ItemCategoryDto> findAllItemCategories();

}
