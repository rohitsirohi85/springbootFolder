package com.ProjectLinkedIn.posts_service.exception;

public class BadRequestException extends  RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
