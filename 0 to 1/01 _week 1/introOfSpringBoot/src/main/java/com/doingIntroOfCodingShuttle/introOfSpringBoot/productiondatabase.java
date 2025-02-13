package com.doingIntroOfCodingShuttle.introOfSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "BeanEnvironment"  , havingValue = "production")
public class productiondatabase implements database {
    
      public String getdata(){
        return "i am prod db";
      }

}
