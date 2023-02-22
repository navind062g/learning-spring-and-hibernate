package com.code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	public static void main(String args[]) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve a bean from the spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//call the method on the container
		System.out.println(theCoach.getDailyWorkout());
		
		//call the method on the container
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}
}
