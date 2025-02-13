package com.Week2HHomeWork.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {

    private Long id;
    private String name;
    private String email;
    private Long salary;

}
