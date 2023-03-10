package com.code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
		System.out.println("Method Name: "+methodSig.getMethod());
		
		// display the method arguments
		Object[] arguments = theJoinPoint.getArgs();
		
		// loop through arguments
		for(Object tempArg: arguments) {
			System.out.println(tempArg);
			
		}
	}
	
	
	
	// display the method arguments
}
