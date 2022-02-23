package com.brillio.config;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.brillio.model.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
@Component
public class JwtTokenGeneratorImpl implements JwtTokenGenerator {
	@Override
	public Map<String, String> generateJwtToken(UserModel user) {
		// Generate Jwt Token
		
		String secretKey="brillio-wave-five";
		
		/*HMACSHA256(
				  base64UrlEncode(header) + "." +
				  base64UrlEncode(payload),
				  
				your-256-bit-secret

				)*/
		String jwtToken="";
		//Factory class useful for creating instances of JWT interfaces.
		jwtToken = Jwts.builder().signWith(SignatureAlgorithm.HS256, secretKey)
		              .setSubject(user.getUserName())
		              .setIssuedAt(new Date())
		              .compact(); 
		
		Map<String, String> map=new HashMap<>();
		map.put("token",jwtToken);
		map.put("message","User Authentication Success");
		
		
		return map;
	}

	
	}
	
	

	


