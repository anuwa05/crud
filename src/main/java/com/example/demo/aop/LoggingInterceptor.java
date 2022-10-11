package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingInterceptor {
    @Pointcut("execution( * com.example.demo.service.*.*(..))")
    public void serviceLogger(){
    }

    @Before("serviceLogger()")
    public void before(JoinPoint jointPoint){
        log.info("Starting Service Execution:: " + jointPoint.getSignature());
    }

    @After("serviceLogger()")
    public void after(JoinPoint jointPoint){
        log.info("Completed Service Execution:: " + jointPoint.getSignature());
    }

}
