package com.doingIntroOfCodingShuttle.introOfSpringBoot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// import org.springframework.stereotype.Component;

// @Component   // we use these when we want to make bean of apple class in it..but don't need when we create bean while configuration apple class by appconfig
public class apple {
    void eating(){
        System.out.println("i am eating an apple");
    }

    @PostConstruct
    void callThisBeforeUsed(){   // before printing..
        System.out.println("creating the apple before used");
    }

    @PreDestroy
    void callBeforeDestroy(){  // wen we use stop button
        System.out.println("destroying bean");
    }
}
