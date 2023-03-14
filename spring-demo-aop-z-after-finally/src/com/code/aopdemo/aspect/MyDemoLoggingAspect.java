package com.code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	@Before("com.code.aopdemo.aspect.AopExpressionsUtility.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>> Executing @Before Advice on method");

		// display the method signatures
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method Name: " + methodSig.getMethod());

		// display the method arguments
		Object[] arguments = theJoinPoint.getArgs();

		// loop through arguments
		for (Object tempArg : arguments) {
			System.out.println(tempArg);

		}
	}
	
	@After("execution(* com.code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterAdviceOnFindAccounts(JoinPoint theJoinPoint) {
		System.out.println("\n======>>> Executing @After Advice on method");
		
		String method = ((MethodSignature)(theJoinPoint.getSignature())).getMethod().toString();
		System.out.println("\n=====>>> Executing @After on method" + method);
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* com.code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingAdviceOnFindAccounts(JoinPoint theJoinPoint, Throwable theExc)
	{
		System.out.println("\n======>>> Executing @AfterThrowing Advice on method");
		// print out which method we are advising on
		String method = ((MethodSignature)(theJoinPoint.getSignature())).getMethod().toString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method" + method);
	
		// log the exception
		System.out.println("\n=====>>> The exception is: "+theExc);
	}

	@AfterReturning(
			pointcut = "execution(* com.code.aopdemo.dao.AccountDAO.findAccounts(..))", 
			returning = "result")
	public void afterReturningAdviceOnFindAccounts(JoinPoint theJoinPoint, List<Account> result) 
	{
		System.out.println("\n======>>> Executing @AfterReturning Advice on method");
		
		// display the method signatures
		MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("Method: "+methodSig.getMethod());
		
		// print out the results of the method call
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method" + method);
		System.out.println("@AfterReturning Result: "+result);
		
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
