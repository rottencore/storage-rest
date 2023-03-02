package ru.vosmfc.mfcstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vosmfc.mfcstorage.dto.ItemDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.service.item.ItemService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/items")
public class ItemController {

    @Autowired
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Void> saveItem(@Valid @RequestBody ItemDto itemDto) throws ObjectAlreadyExistException {
        itemService.saveItem(itemDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> updateItem(@PathVariable(name = "id") Long id, @RequestBody ItemDto itemDto)
            throws ObjectAlreadyExistException, ObjectNotFoundException {
        itemService.updateItem(id, itemDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // TODO может не понадобиться
    @GetMapping(path = "/{id}")
    public ResponseEntity<ItemDto> findItemById(@PathVariable(name = "id") Long id) throws ObjectNotFoundException {
        return new ResponseEntity<>(itemService.findItemById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> findAllItems() {
        return new ResponseEntity<>(itemService.findAllItems(), HttpStatus.OK);
    }

}
