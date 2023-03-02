package ru.vosmfc.mfcstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vosmfc.mfcstorage.dto.RecipientDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.service.recipient.RecipientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/recipients")
public class RecipientController {

    @Autowired
    private final RecipientService recipientService;

    public RecipientController(RecipientService recipientService) {
        this.recipientService = recipientService;
    }

    @PostMapping
    public ResponseEntity<Void> saveRecipient(@Valid @RequestBody RecipientDto recipientDto) throws ObjectAlreadyExistException {
        recipientService.saveRecipient(recipientDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> updateRecipient(@PathVariable(name = "id") Long id, @Valid @RequestBody RecipientDto recipientDto)
            throws ObjectAlreadyExistException, ObjectNotFoundException {
        recipientService.updateRecipient(id, recipientDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RecipientDto>> findAllRecipients() {
        return new ResponseEntity<>(recipientService.findAllRecipients(), HttpStatus.OK);
    }

}
