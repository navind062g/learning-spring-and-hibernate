package com.code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			// simulate a delay
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException ex) {
			// return a delay
			ex.printStackTrace();
		}

		return "Expect a heavy traffic this morning";
	}

}
