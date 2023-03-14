package com.code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAsyncAspect {

	@Before("com.code.aopdemo.aspect.AopExpressionsUtility.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("\n=====>>> Logging to Cloud.");
	}
}
