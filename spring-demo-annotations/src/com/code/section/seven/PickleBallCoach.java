package com.code.section.seven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.code.section.eight.FortuneService;

@Component
public class PickleBallCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	@Qualifier("randomFortuneService")
	public void setFortuneService(FortuneService aFortuneService) {
		this.fortuneService = aFortuneService;
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice with at least one person on Wednesday!";
	}
}
