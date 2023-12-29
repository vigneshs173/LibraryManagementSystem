package com.kgisl.exceptionHandling;

public class InvalidIssueIdException extends RuntimeException{
    public InvalidIssueIdException(String message) {
        super(message);
    }
}
