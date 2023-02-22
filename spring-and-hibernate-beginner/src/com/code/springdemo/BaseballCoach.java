package com.code.springdemo;

public class BaseballCoach implements Coach {
	
	//define a private field for the dependency
	FortuneService theFortuneService;
	
	//inject the dependency through the constructor
	public BaseballCoach(FortuneService aFortuneService) {
		this.theFortuneService = aFortuneService;
	}
	
	
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	
	//get the fortune from the dependency
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return this.theFortuneService.getFortune();
	}
}
