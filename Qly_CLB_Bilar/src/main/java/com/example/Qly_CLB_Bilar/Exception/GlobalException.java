package com.example.Qly_CLB_Bilar.Exception;

import com.example.Qly_CLB_Bilar.DTO.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse> handleRuntimeException(RuntimeException exception){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setCode(1001);
        return ResponseEntity.badRequest().body(apiResponse);
    }
    @ExceptionHandler(value = ConstraintViolationException.class)
    ResponseEntity<String> handleValidException(ConstraintViolationException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
