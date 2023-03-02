package ru.vosmfc.mfcstorage.converter;

import org.springframework.stereotype.Component;
import ru.vosmfc.mfcstorage.domain.Item;
import ru.vosmfc.mfcstorage.dto.ItemDto;

@Component
public class ItemConverter {

    public Item fromItemDtoToItem(ItemDto itemDto) {
        return new Item(itemDto.getItemName(), itemDto.getItemCategory());
    }

    public ItemDto fromItemToItemDto(Item item) {
        return new ItemDto(item.getId(), item.getItemName(), item.getItemCategory());
    }

}
