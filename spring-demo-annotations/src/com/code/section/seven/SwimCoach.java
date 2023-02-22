package com.code.section.seven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.code.section.eight.FortuneService;

@Component
public class SwimCoach implements Coach {
	
	public FortuneService fortuneService;
	
	@Value("${foo.email}")
	public String emailAddress;
	
	@Value("${foo.team}")
	public String teamName;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeamName() {
		return teamName;
	}

	@Autowired
	public SwimCoach(@Qualifier("RESTFortuneService") FortuneService aFortuneService) {
		this.fortuneService = aFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Go to Swim Class indoors for 30 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
}
