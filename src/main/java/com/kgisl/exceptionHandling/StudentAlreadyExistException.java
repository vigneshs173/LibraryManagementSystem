package com.kgisl.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentAlreadyExistException extends RuntimeException{
    public StudentAlreadyExistException(String message) {
        super(message);
    }
}