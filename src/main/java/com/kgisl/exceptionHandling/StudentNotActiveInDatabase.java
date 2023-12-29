package com.kgisl.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotActiveInDatabase extends RuntimeException {
    public StudentNotActiveInDatabase(String message) {
        super(message);
    }
}
