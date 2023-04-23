package com.bridgelabz.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.bridgelabz.exeption.UserExeption;

@Aspect
@Configuration
public class AopService {
	
      Logger logger =LoggerFactory.getLogger(AopService.class);
//	  @Around("execution(* com.bridgelabz.services.UserServiceImp.*(..))")
//	  public Object logingStatement(ProceedingJoinPoint joinPoint) throws Throwable {
//			Object object =joinPoint.proceed();
//			String value =(String) joinPoint.getArgs()[0];
//			
//			if(value.equals("hello")) {
//				return object;
//			}
//		  throw new UserExeption("Check data");
//
//	}
//	  
//	  @Before("execution(*com.bridgelabz.utility.*.*(..))")
//	  public void logStatment(Joinpoint joinpoint ) {
//		   
//		  logger.info("initial Execution :{}",joinpoint.getThis());
//		  
//	  }
//	  @After("execution(*com.bridgelabz.utility.*.*(..))")
//	  public void logStatmentAfter(Joinpoint joinpoint) {
//		   
//		  logger.info("Completed Execution :{}",joinpoint.getThis());
//		  
//	  }
	
	
	
	

}
