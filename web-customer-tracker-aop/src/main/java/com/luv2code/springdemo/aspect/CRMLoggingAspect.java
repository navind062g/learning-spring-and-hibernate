package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());	
	
	// setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// do the same for the service and dao package
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display method we are calling
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>> Executing Method: "+ method);		
		
		// display the arguments to the method
		
		Object[] args = theJoinPoint.getArgs();
		for(Object argument : args) {
			myLogger.info("\n=====>>>> Arguments for above method: "+argument);
		}
	}
	
	
	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()",
			returning = "theResult") 
	public void afterReturning(JoinPoint theJoinPoint, Object theResult)
	{
		// display the method that we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> in @AfterReturning: from method: "+theMethod);
		
		// display data returned
		myLogger.info("=====>>> in @AfterReturning: Result: "+theResult);
	} 
}
