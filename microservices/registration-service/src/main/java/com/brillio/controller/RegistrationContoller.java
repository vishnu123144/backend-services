package com.brillio.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.model.Customer;
import com.brillio.service.RegistrationService;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationContoller {
	
	@Autowired
	private RegistrationService service;
	
	@GetMapping(path = "/register")
    //@ResponseStatus(code =  HttpStatus.OK,reason = "Trail Page")
	public String getReagistrationHomePage() {
		return "Welcome to Registration Page";
	}
	
	@PostMapping("/saveCustomer")
	@ResponseStatus(code =  HttpStatus.CREATED,reason = "Saved Details")
	public String saveCustomerDetails(@RequestBody Customer customer) {
		
		Customer registerCustomer = service.registerCustomer(customer);
		if(registerCustomer!=null) {
			return "Data saved Successfully with Id "+registerCustomer.getId();
		}
		
		
		return "No details Saved. Check your Data";
	}
	
	@GetMapping("/find/{username}/{password}")
	public String getCustomerByUsernameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password) {
		Customer findCustomer = service.getByUsernameAndPassword(username, password);
		if(findCustomer!=null) {
			return "Login successfully " + findCustomer.getId();
		}
		
		return "Invalid Username  and Password";
	}

}
