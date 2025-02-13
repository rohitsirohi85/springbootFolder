package com.doingIntroOfCodingShuttle.introOfSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // used to select which bean we want to run when there is more than one in a program
@ConditionalOnProperty(name = "BeanEnvironment"  , havingValue = "development")
public class developmentDatabase implements database {
   public String getdata(){
    return " i am dev db";    
    }
}
