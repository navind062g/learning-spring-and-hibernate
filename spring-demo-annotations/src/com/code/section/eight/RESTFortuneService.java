package com.code.section.eight;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "This is my rest day!";
	}

}
