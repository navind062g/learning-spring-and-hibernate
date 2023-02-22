package com.coding.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	// new controller method to read the data 
	// add new data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String updateMessage(HttpServletRequest request, Model model)
	{
		// read the request parameter from the HTML Form
		String studentName = request.getParameter("studentName");
		
		// convert the data to all caps
		String result = "Yo! "+studentName.toUpperCase();
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model)
	{		
		// convert the data to all caps
		String result = "Hey, My Friend from Texas is "+ theName.toUpperCase();
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
