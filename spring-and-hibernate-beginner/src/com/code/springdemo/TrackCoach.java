package com.code.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class TrackCoach implements Coach, DisposableBean {

	private FortuneService theFortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService aFortuneService) {
		this.theFortuneService = aFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a Hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return "Track Coach Fortune: "+theFortuneService.getFortune();
	}
	
	// add a initialize method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: Initializing the Bean at Startup.");
	}
	
	//add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: Cleaning Up before closing the Program.");
	}

	@Override
	public void destroy() throws Exception {
		doMyCleanupStuff();
	}
}
