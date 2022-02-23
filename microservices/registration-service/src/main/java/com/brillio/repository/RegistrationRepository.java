package com.brillio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.model.Customer;

@Repository
public interface RegistrationRepository  extends JpaRepository<Customer,Integer>{
    
	//query methods
	// select * from customer where username=name and password=password;
	Customer findByUsernameAndPassword(String name,String password);
	
	
	//@Query("select cus * from Customer where cus.username=? and cus.password=? ")
	
	
}
