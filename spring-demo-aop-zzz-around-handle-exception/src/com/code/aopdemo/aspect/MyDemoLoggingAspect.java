package com.code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;
import com.code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	private static Logger myLogger = 
			Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Around("execution(* com.code.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) 
			throws Throwable
	{
		// print out the method, we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====> Executing @Around on method: "+method);
		
		// get begin timestamp
		long beginTs = System.currentTimeMillis();
		
		// now, lets execute the timestamp
		Object result = theProceedingJoinPoint.proceed();
		
		// get the end timestamp
		long endTs = System.currentTimeMillis();
				
		// compute duration and display it
		long duration = (long) ((endTs - beginTs)/1000.0);
		myLogger.info("\n=====> Duration: "+duration+" seconds");
		
		return null;
	}
	

	// this is where we add all of our related advices for logging

	@Before("com.code.aopdemo.aspect.AopExpressionsUtility.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n======>>> Executing @Before Advice on method");

		// display the method signatures
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method Name: " + methodSig.getMethod());

		// display the method arguments
		Object[] arguments = theJoinPoint.getArgs();

		// loop through arguments
		for (Object tempArg : arguments) {
			myLogger.info(tempArg.toString());

		}
	}
	
	@After("execution(* com.code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterAdviceOnFindAccounts(JoinPoint theJoinPoint) {
		myLogger.info("\n======>>> Executing @After Advice on method");
		
		String method = ((MethodSignature)(theJoinPoint.getSignature())).getMethod().toString();
		myLogger.info("\n=====>>> Executing @After on method" + method);
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* com.code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingAdviceOnFindAccounts(JoinPoint theJoinPoint, Throwable theExc)
	{
		myLogger.info("\n======>>> Executing @AfterThrowing Advice on method");
		// print out which method we are advising on
		String method = ((MethodSignature)(theJoinPoint.getSignature())).getMethod().toString();
		myLogger.info("\n=====>>> Executing @AfterThrowing on method" + method);
	
		// log the exception
		myLogger.info("\n=====>>> The exception is: "+theExc);
	}

	@AfterReturning(
			pointcut = "execution(* com.code.aopdemo.dao.AccountDAO.findAccounts(..))", 
			returning = "result")
	public void afterReturningAdviceOnFindAccounts(JoinPoint theJoinPoint, List<Account> result) 
	{
		myLogger.info("\n======>>> Executing @AfterReturning Advice on method");
		
		// display the method signatures
		MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
		myLogger.info("Method: "+methodSig.getMethod());
		
		// print out the results of the method call
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterReturning on method" + method);
		myLogger.info("@AfterReturning Result: "+result);
		
		if(result != null && !result.isEmpty()) {
			converAccountNamesToUpperCase(result);
		}
		
		
	}

	private void converAccountNamesToUpperCase(List<Account> result) {
		for(Account acc: result) {
			String name = acc.getName();
			acc.setName(name.toUpperCase());
		}
	}
}
