package com.doingIntroOfCodingShuttle.introOfSpringBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration    // configure the apple class
public class appconfig {
    @Bean  // used to create the bean inside @Configuration
   // @Scope("singleton")  // it means that single object is invoking the same bean
    @Scope("prototype")  // it means that different object is invoking the same bean
    apple getapple(){  // factory method to make object of configuration class
        return new apple();
    }
}
