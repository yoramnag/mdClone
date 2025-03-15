package com.example.mdClone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ManagerAllReadyExistsException extends RuntimeException{

    public ManagerAllReadyExistsException(String message) {
        super(message);
    }
}
