package ru.integration.paymentstatefeeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class CommonExceptionHandler {
    private final static Logger log = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> badRequestExceptionHandler(Exception exception) {
        log.warn(exception.getMessage());
        ErrorResponse error = ErrorResponse.builder(exception.fillInStackTrace(), BAD_REQUEST, exception.getMessage())
                .build();
        return new ResponseEntity<>(error, BAD_REQUEST);
    }
}
