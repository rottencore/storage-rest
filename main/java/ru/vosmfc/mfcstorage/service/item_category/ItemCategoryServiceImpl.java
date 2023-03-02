package ru.vosmfc.mfcstorage.service.item_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vosmfc.mfcstorage.converter.ItemCategoryConverter;
import ru.vosmfc.mfcstorage.domain.ItemCategory;
import ru.vosmfc.mfcstorage.dto.ItemCategoryDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.repository.ItemCategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private final ItemCategoryRepository itemCategoryRepository;

    @Autowired
    private final ItemCategoryConverter itemCategoryConverter;

    public ItemCategoryServiceImpl(ItemCategoryRepository itemCategoryRepository, ItemCategoryConverter itemCategoryConverter) {
        this.itemCategoryRepository = itemCategoryRepository;
        this.itemCategoryConverter = itemCategoryConverter;
    }

    @Override
    public void saveItemCategory(ItemCategoryDto itemCategoryDto) throws ObjectAlreadyExistException {
        try {
            itemCategoryRepository.save(itemCategoryConverter.fromItemCategoryDtoToItemCategory(itemCategoryDto));
        } catch (Exception exception) {
            throw new ObjectAlreadyExistException("Item category with name " + itemCategoryDto.getCategoryName() + " already exist.");
        }
    }

    @Override
    public List<ItemCategoryDto> findAllItemCategories() {
        List<ItemCategoryDto> itemCategoryDtoList = new ArrayList<>();
        List<ItemCategory> itemCategories = itemCategoryRepository.findAll();

        for (ItemCategory itemCategory : itemCategories) {
            itemCategoryDtoList.add(itemCategoryConverter.fromItemCategoryToItemCategoryDto(itemCategory));
        }

        return itemCategoryDtoList;
    }

}
