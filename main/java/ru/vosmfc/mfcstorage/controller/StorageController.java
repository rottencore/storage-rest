package ru.vosmfc.mfcstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vosmfc.mfcstorage.dto.StorageDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.exception.QuantityException;
import ru.vosmfc.mfcstorage.service.storage.StorageService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/storages")
public class StorageController {

    @Autowired
    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public ResponseEntity<Void> saveStorage(@Valid @RequestBody StorageDto storageDto) throws ObjectAlreadyExistException {
        storageService.saveStorage(storageDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> updateStorageQuantity(@PathVariable(name = "id") Long id, @Valid @RequestBody StorageDto storageDto)
            throws ObjectAlreadyExistException, ObjectNotFoundException, QuantityException {
        storageService.updateStorageItemQuantity(id, storageDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StorageDto> findStorageById(@PathVariable(name = "id") Long id) throws ObjectNotFoundException {
        return new ResponseEntity<>(storageService.getStorageById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StorageDto>> findAllStorages() {
        return new ResponseEntity<>(storageService.findAllStorages(), HttpStatus.OK);
    }

}
