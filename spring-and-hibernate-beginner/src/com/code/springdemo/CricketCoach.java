package com.code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("CricketCoach: insider setter method - setEmailAddress");
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("CricketCoach: insider setter method - setTeam");
	}

	//create a no argument constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no argument constructor");
	}	

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice Cricket for at least 2 hours daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
