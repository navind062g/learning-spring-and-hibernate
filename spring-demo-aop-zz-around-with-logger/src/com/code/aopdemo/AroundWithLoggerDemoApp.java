package com.code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("\nCalling getFortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nFortune: "+data);
		
		// close the context
		context.close();

	}

}
