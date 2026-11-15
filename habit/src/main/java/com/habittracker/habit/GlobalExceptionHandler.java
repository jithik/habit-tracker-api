package com.habittracker.habit;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex)
    {
        Map<String, String> fieldErrors=ex.getBindingResult().getFieldErrors().stream()
        .collect(Collectors.toMap(FieldError:: getField, FieldError :: getDefaultMessage,(first, secod) -> first));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
    }

    @ExceptionHandler(HabitNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(HabitNotFoundException ex)
    {
        Map<String,String> error=Map.of("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }



}
