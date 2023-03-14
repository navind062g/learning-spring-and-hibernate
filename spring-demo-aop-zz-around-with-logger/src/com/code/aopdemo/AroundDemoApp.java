package com.code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("\nCalling getFortune");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\nFortune: "+data);
		
		// close the context
		context.close();

	}

}
