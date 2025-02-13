package com.SpringSecurity.SpringSecurityAppliication.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.SpringSecurity.SpringSecurityAppliication.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandle {
    
         @ExceptionHandler(ResourceNotFoundException.class)
         
        public ResponseEntity<ApiError> handlingResourceNotFoundException(ResourceNotFoundException exception){
           ApiError apiError =new ApiError(exception.getLocalizedMessage() , HttpStatus.NOT_FOUND);
           return new ResponseEntity<>(apiError , HttpStatus.NOT_FOUND);
        }
}
