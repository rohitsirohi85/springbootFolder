package com.Aop.AopLearning.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectsV2 {

    // another way to use better pointcut create a method pointcut with path which is highly repeat using @pointcut

    @Pointcut("execution(* com.Aop.AopLearning.services.impl.*.*(..))")
    public void ServiceMethodCall(){

    }

    @Before("ServiceMethodCall()")
    public void beforeMethodCall(){
        log.info("before Service method");
    }

//    @After("ServiceMethodCall()")
      @AfterReturning(value = "ServiceMethodCall()" ,returning = "returnedObj")  // only run for which method does,nt throw any exception and return something successful(orderPackage)
//    @AfterThrowing("ServiceMethodCall()")  // only run for which method throw any exception (trackOrder)
    public void afterMethodCall(JoinPoint joinPoint , Object returnedObj){
        log.info("after Service method ,{}",joinPoint.getSignature());  // give the joinPoint signature and return the object value(only run for successful methods)
          log.info("after Service method ,{}",returnedObj);
    }


    @Around("ServiceMethodCall()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object returnedValue = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();

        Long diff = endTime-startTime;

        log.info("execution time is {}",diff);
        return returnedValue;
    }

}
