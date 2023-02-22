package com.code.section.ten;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.code.section.eight.FileFortuneService;
import com.code.section.eight.FortuneService;

@Configuration
@ComponentScan("com.code.section")
@PropertySource("classpath:sports.properties")
public class SportConfig {
	// define bean for sad fortune service
	@Bean
	@Scope("prototype")
	public FortuneService sadFortuneService() {
		return new FileFortuneService();
	}
	
	//define bean for our swim coach and inject dependency
	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
