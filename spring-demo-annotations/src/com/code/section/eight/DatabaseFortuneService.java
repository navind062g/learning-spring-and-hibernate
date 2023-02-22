package com.code.section.eight;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Database Service is All is Well!";
	}

}
