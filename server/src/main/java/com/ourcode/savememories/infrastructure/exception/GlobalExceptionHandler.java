package com.ourcode.savememories.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ourcode.savememories.infrastructure.exception.memory.MemoryCreationException;
import com.ourcode.savememories.infrastructure.exception.memory.MemoryNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MemoryCreationException.class)
    public ResponseEntity<String> handleMemoryCreateionException(MemoryCreationException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(MemoryNotFoundException.class)
    public ResponseEntity<String> handleMemoryNotFoundException(MemoryNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
