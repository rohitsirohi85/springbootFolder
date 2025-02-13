package com.ZomatoProject.Zomato_app.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private LocalDateTime timeStamp;
    private ApiError error;
    private T data;



    public ApiResponse(){
        this.timeStamp=LocalDateTime.now();
    }

    public ApiResponse(T data){
        this();   // calling the default constructor
        this.data=data;
    }

    public ApiResponse(ApiError error){
        this();
        this.error=error;
    }

}
