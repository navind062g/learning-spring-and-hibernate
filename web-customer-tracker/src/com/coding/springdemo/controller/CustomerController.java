package com.coding.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.springdemo.dao.CustomerDAO;
import com.coding.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	/*need to inject the customer dao* */
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		// get the customers from the dao
		List<Customer> customers = customerDAO.getCustomers();
		
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
