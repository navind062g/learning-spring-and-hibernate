package com.code.section.ten;

import com.code.section.eight.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Today is a Sad Day!";
	}

}
