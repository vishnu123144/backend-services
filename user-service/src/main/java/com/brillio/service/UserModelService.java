package com.brillio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.model.UserModel;
import com.brillio.repository.UserModelRepository;

@Service
public class UserModelService {
	
	@Autowired
	 private UserModelRepository userRespository;
	 
	 
	 
	 public UserModel getUserNameAndPassword(String name,String password) {
	  return userRespository.findByUserNameAndPassword(name, password);
	 }
	 
	 public List<UserModel> getAllUser() {
		  return userRespository.findAll();
		 }

	 
	
	
	
	
}
