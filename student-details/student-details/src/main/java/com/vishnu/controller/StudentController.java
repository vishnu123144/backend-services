package com.vishnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.exception.ResourceNotFoundException;
import com.vishnu.model.Student;
import com.vishnu.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    
	@Autowired
	private StudentService service;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudentData(@RequestBody Student student){
		Student body = service.saveStudentDetails(student);
		return ResponseEntity.ok(body);
	}
	
	@GetMapping("/getStudent")
	public List<Student> getStudentData(){
		return service.getAllStudents();
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		Object id1=service.getStudentById(id);	
		return new ResponseEntity<Object>(id1,HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudentData(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudentData(@PathVariable("id") Long id) {
		return service.deleteStudent(id);
	}
	
	
}
