package ru.vosmfc.mfcstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vosmfc.mfcstorage.dto.PositionDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.service.position.PositionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/positions")
public class PositionController {

    @Autowired
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping
    public ResponseEntity<Void> savePosition(@Valid @RequestBody PositionDto positionDto) throws ObjectAlreadyExistException {
        positionService.savePosition(positionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PositionDto>> findAllPositions() {
        return new ResponseEntity<>(positionService.findAllPositions(), HttpStatus.OK);
    }

}
