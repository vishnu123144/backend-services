package com.brillio.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WelcomeController {
	
	
	@GetMapping("/")
	public ModelAndView getIndexPage(ModelAndView model)
	
	{
		model.setViewName("index");
		return model;
	}
	
	@GetMapping("/home")
	public String getHome()
	{
		return "welcome to home";
	}


}
