package com.code.section.ten;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.section.seven.Coach;

public class JavaConfigDemoApp {
	public static void main(String[] args) {
		// read the spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from the spring container
		Coach newCoach = context.getBean("tennisCoach", Coach.class);
		
		// call a method from the bean
		System.out.println("\n===============New Coach===============");
		
		System.out.println(newCoach.getDailyWorkout());
		
		System.out.println(newCoach.getDailyFortune());
		
		// close the context
		context.close();
	}
}
