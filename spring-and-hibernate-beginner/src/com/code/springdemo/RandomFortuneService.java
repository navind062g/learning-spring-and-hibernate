package com.code.springdemo;

public class RandomFortuneService implements FortuneService {
	
	String[] messages = new String[] {
			"Today is your lucky Day!",
			"Today is the best day for selling your stocks!",
			"Today is the best day to purchase Tech Stocks!",
			"Today is the last day to invest in ETF!"
	};
	
	public RandomFortuneService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getFortune() {
		int randomIndex = (int)(Math.random() * messages.length);
		return messages[randomIndex];
	}

}
