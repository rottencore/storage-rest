package ru.vosmfc.mfcstorage.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.security.dto.UserDto;
import ru.vosmfc.mfcstorage.security.service.user.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/admin/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(@Valid @RequestBody UserDto userDto) throws ObjectAlreadyExistException {
        userService.saveUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable(name = "id") Long id, @Valid @RequestBody UserDto userDto)
            throws ObjectNotFoundException, ObjectAlreadyExistException {
        userService.updateUser(id, userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/lock/{id}")
    public ResponseEntity<Void> lockUser(@PathVariable(name = "id") Long id) throws ObjectNotFoundException {
        userService.lockUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable(name = "id") Long id) throws ObjectNotFoundException {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

}
