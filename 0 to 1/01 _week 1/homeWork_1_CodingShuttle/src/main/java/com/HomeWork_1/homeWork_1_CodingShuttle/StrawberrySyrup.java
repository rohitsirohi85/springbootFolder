package com.HomeWork_1.homeWork_1_CodingShuttle;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StrawberrySyrup implements SyrupInterface {
    public String getSyrup(){
        return "strawberrySyrup";
    }
}
