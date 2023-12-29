package com.kgisl.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ResponseError> handleStudentNotFoundException(StudentNotFoundException e) {
        ResponseError responseError = new ResponseError(401,e.getMessage());
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentNotActiveInDatabase.class)
    public ResponseEntity<ResponseError> handleStudentNotActiveInDatabase(StudentNotActiveInDatabase e) {
        ResponseError responseError = new ResponseError(402,e.getMessage());
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentAlreadyExistException.class)
    public ResponseEntity<ResponseError> handleStudentAlreadyExistException(StudentAlreadyExistException e) {
        ResponseError responseError = new ResponseError(403,e.getMessage());
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidStudentIdAndBookId.class)
    public ResponseEntity<ResponseError> handleInvalidStudentIdAndBookId(InvalidStudentIdAndBookId e) {
        ResponseError responseError = new ResponseError(425,e.getMessage());
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ResponseError> handleBookNotFoundException(BookNotFoundException e) {
        ResponseError responseError = new ResponseError(455,e.getMessage());
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(IssuesNotFoundException.class)
    public ResponseEntity<ResponseError> handleBookIssuesNotFoundException(IssuesNotFoundException e) {
        ResponseError responseError = new ResponseError(465,e.getMessage());
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(IssueAlreadyReturnedException.class)
    public ResponseEntity<ResponseError> handleIssueAlreadyReturnedException(IssueAlreadyReturnedException e) {
        ResponseError responseError = new ResponseError(466,e.getMessage());
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

}
