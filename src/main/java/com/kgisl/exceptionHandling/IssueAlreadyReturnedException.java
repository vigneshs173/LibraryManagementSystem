package com.kgisl.exceptionHandling;

public class IssueAlreadyReturnedException extends RuntimeException{
    public IssueAlreadyReturnedException(String message){
        super(message);
    }
}
