package com.CorrencyConverter.CorrencyConverter.advices;

import com.CorrencyConverter.CorrencyConverter.exception.ResourceNotFoundException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<ApiError> handlingResourceNotFoundException(ResourceNotFoundException exception){
        ApiError apiError =new ApiError(exception.getLocalizedMessage() , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handlingAuthenticationException(AuthenticationException exception){
        ApiError apiError = new ApiError(exception.getLocalizedMessage() , HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apiError , HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(JwtException.class)   // for using the JWT exception u need to use handlerResolver in jwtAuthFilter
    public ResponseEntity<ApiError> handlingJwtException(JwtException exception){
        ApiError apiError = new ApiError(exception.getLocalizedMessage() , HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apiError , HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handlingJwtException(RuntimeException exception){
        ApiError apiError = new ApiError(exception.getLocalizedMessage() , HttpStatus.BAD_GATEWAY);
        return new ResponseEntity<>(apiError , HttpStatus.BAD_GATEWAY);
    }
}

