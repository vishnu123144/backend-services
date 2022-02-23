package com.brillio.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

//used check for valid token generated
@RestController
public class JwtAuthTokenFilter implements Filter {

	

	@Override
	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	   throws IOException, ServletException {

	  HttpServletRequest req = (HttpServletRequest) request;
	  HttpServletResponse res = (HttpServletResponse) response;
	  String headerToken = req.getHeader("authorization");//token will be send only in the header

	  try {
		  String token=headerToken.split(" ")[1];

	   Claims claim= Jwts.parser()
	    .setSigningKey("brillio-wave-five")
	    .parseClaimsJws(token)
	    .getBody();
	   
	   System.out.println(claim.getSubject() +"--" + claim.getIssuedAt());
	   
	   chain.doFilter(request, response);
	   
	   

	  } catch (Exception e) {
	   res.sendRedirect("/unauthoried");

	  }

	 }
	 
	 @GetMapping("//unauthoried")
	 public String invalidToken() {
	  return "Access Denied -  Your not the Authorized Person";
	 }

	

}
