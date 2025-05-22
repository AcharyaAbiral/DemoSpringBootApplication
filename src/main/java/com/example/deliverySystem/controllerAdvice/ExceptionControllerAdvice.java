package com.example.deliverySystem.controllerAdvice;

import com.example.deliverySystem.myCustomException.LocationNotFoundException;
import com.example.deliverySystem.myCustomException.ParcelNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ParcelNotFoundException.class)
    public ResponseEntity<String> parcelNotFoundExceptionHandler(ParcelNotFoundException ex)
    {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<String> locationNotFoundExceptionHandler(LocationNotFoundException ex)
    {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex)
    {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
