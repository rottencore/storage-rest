package ru.vosmfc.mfcstorage.service.item;

import ru.vosmfc.mfcstorage.dto.ItemDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;

import java.util.List;

public interface ItemService {

    void saveItem(ItemDto itemDto) throws ObjectAlreadyExistException;

    void updateItem(Long id, ItemDto itemDto) throws ObjectAlreadyExistException, ObjectNotFoundException;

    ItemDto findItemById(Long id) throws ObjectNotFoundException;

    List<ItemDto> findAllItems();

}
