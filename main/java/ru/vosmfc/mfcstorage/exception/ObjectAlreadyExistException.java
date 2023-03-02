package ru.vosmfc.mfcstorage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjectAlreadyExistException extends Exception {

    public ObjectAlreadyExistException(String message) {
        super(message);
    }

}
