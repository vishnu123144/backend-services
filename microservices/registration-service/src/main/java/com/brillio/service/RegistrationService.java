package com.brillio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.model.Customer;
import com.brillio.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repository;
	
	public Customer registerCustomer(Customer customer) {
		return repository.save(customer);
	}
	
	public Customer getByUsernameAndPassword(String name,String password) {
	     
		return repository.findByUsernameAndPassword(name, password);
			
	}
	

}
