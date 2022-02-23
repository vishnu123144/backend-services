package com.brillio.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 @Bean
	 public FilterRegistrationBean getFilterRegistration() {
	  FilterRegistrationBean bean=new FilterRegistrationBean();
	  bean.setFilter(new JwtAuthTokenFilter()); // check for valid tokens
	  bean.addUrlPatterns("/list");
	  return bean;
	 }
}
