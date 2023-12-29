package com.kgisl.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseError {

    private int errorCode;
    private String errorMessage;

    /*public ResponseError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }*/

    public String toString() {
        return "Error Code : " + this.errorCode + " Error Message: " + this.errorMessage;
    }
}
