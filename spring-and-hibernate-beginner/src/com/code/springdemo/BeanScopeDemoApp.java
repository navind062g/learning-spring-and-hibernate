package com.code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// get context from the spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
				
		// retrieve the beans from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// perform operations on coach
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPointing to the same object: "+result);
		
		System.out.println("\nMemory Location for theCoach: "+theCoach);
		
		System.out.println("\nMemory Location for alphaCoach: "+alphaCoach+"\n");
		
		// close the context
		context.close();
	}

}
