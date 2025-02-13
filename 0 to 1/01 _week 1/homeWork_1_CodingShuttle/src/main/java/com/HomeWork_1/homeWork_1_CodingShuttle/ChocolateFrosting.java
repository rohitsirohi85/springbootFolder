package com.HomeWork_1.homeWork_1_CodingShuttle;

import org.springframework.stereotype.Component;

@Component
public class ChocolateFrosting implements FrostingInterface {
    public String getFrosting(){
        return " chocolate frosting";
    }
}
