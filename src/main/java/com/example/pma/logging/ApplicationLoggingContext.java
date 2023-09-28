package com.example.pma.logging;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;

//import java.util.logging.Logger;

@Aspect
@Component
public class ApplicationLoggingContext {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.example.pma.controllers..*)")
    public void definePackagePointCuts(){

    }
    @After("definePackagePointCuts()")
    public void log(){
        logger.debug("--------------===================---------------");
    }
}
