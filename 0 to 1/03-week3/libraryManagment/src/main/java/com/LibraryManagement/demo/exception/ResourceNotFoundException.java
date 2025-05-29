package com.LibraryManagement.demo.exception;

import lombok.Data;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
