package com.brillio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.model.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel,String>{
	// Query Methods

	 // private String userName; private String password;
	    // select * from usermodel where username=? and password =?
	// Query Methods

	 // private String userName; private String password;
	    // select * from usermodel where username=? and password =?
	 UserModel findByUserNameAndPassword(String username,String password);

	 // @Query()
	 //

}
