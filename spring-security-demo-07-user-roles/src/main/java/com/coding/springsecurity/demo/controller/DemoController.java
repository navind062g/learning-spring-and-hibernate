package com.coding.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	/* Add request mapping for the leaders*/
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	/* Add request mapping for the systems */
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}
}
