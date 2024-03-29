package com.example.simpleapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientIdException extends RuntimeException {

    public ClientIdException(String message) {
        super(message);
    }
}
