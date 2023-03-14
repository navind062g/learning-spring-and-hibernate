package com.code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressionsUtility {
	
	// lets start with an Before Annotation Advice
	@Pointcut("execution(* com.code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create point cut for the getter methods
	@Pointcut("execution(* com.code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create point cut for the setter methods
	@Pointcut("execution(* com.code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create point: include package... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
}
