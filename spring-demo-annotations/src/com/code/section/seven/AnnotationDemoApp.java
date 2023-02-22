package com.code.section.seven;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
	public static void main(String[] args) {
		// read the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from the spring container
		//SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		Coach newCoach = context.getBean("tennisCoach", Coach.class);
		
		// call a method from the bean
		/*ystem.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("Swim Coach Name: "+theCoach.getEmailAddress());
		
		System.out.println("Swim Team Name: "+theCoach.getTeamName());
		*/
		System.out.println("\n===============New Coach===============");
		
		System.out.println(newCoach.getDailyWorkout());
		
		System.out.println(newCoach.getDailyFortune());
		
		// close the context
		context.close();
	}
}
