package com.kgisl.exceptionHandling;

public class IssuesNotFoundException extends RuntimeException{
    public IssuesNotFoundException(String message){
        super(message);
    }
}
