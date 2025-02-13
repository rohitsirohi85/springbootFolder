package com.codingshuttle.cachingApp.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDto implements Serializable {  // must to implement serializable inside result data for using redis
    private Long id;
    private String email;
    private String name;
    private Long salary;
}
