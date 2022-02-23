package com.brillio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.config.JwtTokenGenerator;
import com.brillio.model.UserModel;
import com.brillio.service.UserModelService;

@RestController
public class UserModelController {
	
	   
	 @Autowired
	 private UserModelService uService;
	 
	 @Autowired
	 private JwtTokenGenerator tokenGenerator;
	 
	 @GetMapping("list")
	 public List<UserModel> getUserList() {
	  return uService.getAllUser();
	 }
	 @PostMapping("/login")
		public ResponseEntity<Object> loginUserModel(@RequestBody UserModel user) {
			
			UserModel model = uService.getUserNameAndPassword(user.getUserName(), user.getPassword());
			if(model !=null) {
				Map<String, String> generateJwtToken = tokenGenerator.generateJwtToken(model);
				return new ResponseEntity<>(generateJwtToken, HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>("Invalid Usernaes and password", HttpStatus.CONFLICT);
			}
			
	 }
	 

}
