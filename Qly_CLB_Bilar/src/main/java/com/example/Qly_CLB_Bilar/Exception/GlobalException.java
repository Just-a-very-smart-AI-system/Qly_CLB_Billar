package com.example.Qly_CLB_Bilar.Exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handleRuntimeException(RuntimeException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
    @ExceptionHandler(value = ConstraintViolationException.class)
    ResponseEntity<String> handleValidException(ConstraintViolationException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
