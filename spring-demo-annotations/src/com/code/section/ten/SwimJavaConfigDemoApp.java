package com.code.section.ten;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.section.seven.Coach;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// read the spring configuration from the java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// create a bean using configuration
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call the required methods on the bean
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getEmailAddress());
		
		System.out.println(theCoach.getTeamName());
		
		//close the context
		context.close();
	}

}
