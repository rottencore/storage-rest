package ru.vosmfc.mfcstorage.service.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vosmfc.mfcstorage.converter.ItemConverter;
import ru.vosmfc.mfcstorage.domain.Item;
import ru.vosmfc.mfcstorage.dto.ItemDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemRepository itemRepository;

    @Autowired
    private final ItemConverter itemConverter;

    public ItemServiceImpl(ItemRepository itemRepository, ItemConverter itemConverter) {
        this.itemRepository = itemRepository;
        this.itemConverter = itemConverter;
    }

    @Override
    public void saveItem(ItemDto itemDto) throws ObjectAlreadyExistException {
        itemRepository.save(itemConverter.fromItemDtoToItem(itemDto));
    }

    @Override
    public void updateItem(Long id, ItemDto itemDto) throws ObjectAlreadyExistException, ObjectNotFoundException {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Item with id " + id + " not found"));

        item.setItemName(itemDto.getItemName());
        item.setItemCategory(itemDto.getItemCategory());
        try {
            itemRepository.save(item);
        } catch (Exception exception) {
            throw new ObjectAlreadyExistException("Item with item name " + itemDto.getItemName() + " already exist.");
        }
    }

    @Override
    public ItemDto findItemById(Long id) throws ObjectNotFoundException {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Item with id " + id + " not found"));

        return itemConverter.fromItemToItemDto(item);
    }

    @Override
    public List<ItemDto> findAllItems() {
        List<ItemDto> itemDtoList = new ArrayList<>();
        List<Item> items = itemRepository.findAll();

        for (Item item : items) {
            itemDtoList.add(itemConverter.fromItemToItemDto(item));
        }

        return itemDtoList;
    }

}
