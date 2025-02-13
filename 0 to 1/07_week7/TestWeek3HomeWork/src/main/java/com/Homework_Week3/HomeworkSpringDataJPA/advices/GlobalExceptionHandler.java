package com.Homework_Week3.HomeworkSpringDataJPA.advices;

import com.Homework_Week3.HomeworkSpringDataJPA.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<?>handlingResourceNotFoundException(ResourceNotFoundException exception){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?>handlingRuntimeException(RuntimeException exception){
        return ResponseEntity.internalServerError().build();
    }
}
