package com.codej.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorRecord> handleDefaultException(Exception ex,
                                                                          WebRequest request) {
        CustomErrorRecord error = new CustomErrorRecord(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorRecord> handleModelNotFoundException(ModelNotFoundException ex,
                                                                          WebRequest request) {
        CustomErrorRecord error = new CustomErrorRecord(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
