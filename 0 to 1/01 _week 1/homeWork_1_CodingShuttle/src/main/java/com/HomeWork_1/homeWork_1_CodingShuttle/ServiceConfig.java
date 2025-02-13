package com.HomeWork_1.homeWork_1_CodingShuttle;
 import org.springframework.stereotype.Component;

 @Component
public class ServiceConfig {
    private final FrostingInterface frost;
    private final SyrupInterface syp;

    

    public ServiceConfig(FrostingInterface frost , SyrupInterface syp ){
        this.frost=frost;
        this.syp=syp;
    }

    public String bakecake(){
        return "cake made with:" + syp.getSyrup() + " and " + frost.getFrosting();
        
    }

}
