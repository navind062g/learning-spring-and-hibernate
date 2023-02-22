package com.code.section.eight;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	String[] messages = new String[] {
			"Today is your lucky Day!",
			"Today is the best day for selling your stocks!",
			"Today is the best day to purchase Tech Stocks!",
			"Today is the last day to invest in ETF!"
	};
	
	@Override
	public String getDailyFortune() {
		int randomIndex = (int)(Math.random() * messages.length);
		return messages[randomIndex];
	}
}
