package com.Aop.AopLearning.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ValidationAspects {

     // here we make a logic to check the validation for service methods

    @Pointcut("execution(* com.Aop.AopLearning.services.impl.*.*(..))")
    public void ServiceValidationMethodCall(){

    }
    @Around("ServiceValidationMethodCall()")
    public Object ValidTheOrderId(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
           Object[]args = proceedingJoinPoint.getArgs();

           Long orderId = (Long)args[0];


           if (orderId>0)return proceedingJoinPoint.proceed();  // if orderId > than 0 so run success
           return "call method can't possible for negative value (orderId)"+orderId;
    }



}
