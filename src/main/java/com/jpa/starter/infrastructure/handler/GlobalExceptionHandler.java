package com.jpa.starter.infrastructure.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = getValidationMessage(e.getBindingResult());
        log.error(msg, e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(msg);
    }

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<?> handleBindException(BindException e) {
        String msg = getValidationMessage(e.getBindingResult());
        log.error(msg, e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(msg);
    }

    private String getValidationMessage(BindingResult result) {
        StringBuilder sb = new StringBuilder("Properties : ");
        for (FieldError fieldError : result.getFieldErrors()) {
            sb.append("'[").append(fieldError.getField()).append("] ").append(fieldError.getDefaultMessage()).append("', ");
        }
        return sb.toString();
    }
}
