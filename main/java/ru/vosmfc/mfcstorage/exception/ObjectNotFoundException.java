package ru.vosmfc.mfcstorage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjectNotFoundException extends Exception {

    public ObjectNotFoundException(String message) {
        super(message);
    }

}
