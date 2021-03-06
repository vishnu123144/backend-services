package com.brillio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.model.Student;
import com.brillio.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveLaptop(@RequestBody Student student)
	{
		Student save=service.saveStudentDetails(student);
		if(save!=null) {
		return new ResponseEntity<Object>(save,HttpStatus.CREATED);
		}else
		{
			return new ResponseEntity<Object>("no data found",HttpStatus.CONFLICT);
		}
	}
	
	
	

}
