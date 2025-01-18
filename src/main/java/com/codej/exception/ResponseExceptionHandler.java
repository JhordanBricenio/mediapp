package com.codej.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorRecord> methodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                    WebRequest request) {

        String msg= ex.getBindingResult().getFieldErrors().stream()
                .map(e ->   e.getField().concat(": ").concat(e.getDefaultMessage()))
                .collect(Collectors.joining(", "));

        CustomErrorRecord error = new CustomErrorRecord(LocalDateTime.now(),
                msg, request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
