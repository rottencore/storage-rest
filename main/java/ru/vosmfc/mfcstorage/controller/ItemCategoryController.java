package ru.vosmfc.mfcstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vosmfc.mfcstorage.dto.ItemCategoryDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.service.item_category.ItemCategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/item_categories")
public class ItemCategoryController {

    @Autowired
    private final ItemCategoryService itemCategoryService;

    public ItemCategoryController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @PostMapping
    public ResponseEntity<Void> saveItemCategory(@Valid @RequestBody ItemCategoryDto itemCategoryDto) throws ObjectAlreadyExistException {
        itemCategoryService.saveItemCategory(itemCategoryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemCategoryDto>> findAllItemCategories() {
        return new ResponseEntity<>(itemCategoryService.findAllItemCategories(), HttpStatus.OK);
    }

}
