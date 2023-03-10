package com.code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// lets start with an Before Annotation Advice
	@Pointcut("execution(* com.code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create point cut for the getter methods
	@Pointcut("execution(* com.code.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create point cut for the setter methods
	@Pointcut("execution(* com.code.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create point: include package... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before Advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API Analytics.");
	}

}
