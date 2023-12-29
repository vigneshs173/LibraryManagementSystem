package com.kgisl.exceptionHandling;

public class InvalidStudentIdAndBookId extends RuntimeException{
    public InvalidStudentIdAndBookId(String message){
        super(message);
    }
}
