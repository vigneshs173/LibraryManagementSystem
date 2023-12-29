package com.kgisl.exceptionHandling;

public class BookOutOfStackException extends RuntimeException{
    public BookOutOfStackException(String message){
        super(message);
    }
}
