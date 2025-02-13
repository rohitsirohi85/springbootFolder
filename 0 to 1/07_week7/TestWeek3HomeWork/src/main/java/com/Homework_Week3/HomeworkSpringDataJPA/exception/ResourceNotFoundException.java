package com.Homework_Week3.HomeworkSpringDataJPA.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
