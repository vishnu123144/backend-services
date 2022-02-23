package com.brillio.config;

import java.util.Map;

import com.brillio.model.UserModel;

public interface JwtTokenGenerator {
	public Map<String,String> generateJwtToken(UserModel user);


	
}
