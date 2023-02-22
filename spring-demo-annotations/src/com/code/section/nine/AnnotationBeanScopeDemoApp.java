package com.code.section.nine;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.code.section.seven.Coach;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// call methods which are required
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nAre the two objects equal: "+ result);
		
		System.out.println("\nMemory location for theCaoch: "+theCoach);
		
		System.out.println("\nMemory location for alphaCaoch: "+alphaCoach);
		
		// close the context for spring config file
		context.close();
	}

}
