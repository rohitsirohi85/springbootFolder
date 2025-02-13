package com.Homework_Week3.HomeworkSpringDataJPA.conffig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

     @Bean
    ModelMapper getModelMapper(){
         return new ModelMapper();
     }

}
