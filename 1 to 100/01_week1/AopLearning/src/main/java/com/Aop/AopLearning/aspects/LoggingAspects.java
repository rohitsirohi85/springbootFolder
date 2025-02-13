package com.Aop.AopLearning.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect    // commenting bcz for checking loggingAspectV2
@Component
@Slf4j
public class LoggingAspects {

   // @Before("execution(* orderPackage(..))")   // used to called , the aspect before order package method and * means that in this application anywhere uses orderPackage method so call this before that method
    @Before("execution(* com.Aop.AopLearning.services.impl.ShipmentServiceImpl.orderPackage(..))")   // only use aspect before the method name is orderPackage which is inside the ShipmentServiceImpl only
    public void beforeOrderPackage(){
        log.info("Before order package called from logging aspects");
    }


    @Before("execution(* com.Aop.AopLearning.services.impl.*.*(..))")  // use before any method inside service>impl
    public void beforeAllMethod(JoinPoint joinPoint){  // joinPoints used to add some additional behaviours
        log.info("Before any method called from logging aspects,{}",joinPoint.getKind()); // kind means type of joinPoint
        log.info("Before any method called from logging aspects,{}",joinPoint.getSignature()); // signature means path and argument
    }

    @Before("within(com.Aop.AopLearning..*)") // call within given path's any method ,package,constructor,class all
    public void beforeWithinAnyPointcut(){
        log.info("calling from within");
    }

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforeTransactionalAnnotationCall(){
        log.info("before transactional annotation calls");
    }
    @Before("@annotation(com.Aop.AopLearning.aspects.MyLogging)")
    public void beforeCustomAnnotationCall(){
        log.info("before My logging(custom annotation) annotation calls");
    }



}
