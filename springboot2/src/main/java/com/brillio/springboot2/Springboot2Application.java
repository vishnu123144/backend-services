package com.brillio.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.brillio")
@SpringBootApplication
public class Springboot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2Application.class, args);
	}

}
