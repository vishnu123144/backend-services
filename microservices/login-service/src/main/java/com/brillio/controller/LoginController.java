package com.brillio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/login")
public class LoginController {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/user/{username}/{password}")
	public String getLogin(@PathVariable("username") String username,@PathVariable("password") String password) {
	
		//String url="http://localhost:8082/registration/find/"+username+"/"+password;
		
		String url="http://REGISTRATION-SERVICE/registration/find/"+username+"/"+password;
		
		String message = restTemplate.getForObject(url, String.class);
		
		return message;
		
	}
	
	@GetMapping("user")
	//@ResponseStatus(code = HttpStatus.OK)
	public String getLoginPage() {
		return "Welcome to Login Page";
	}
	
	
	
	
	
}
