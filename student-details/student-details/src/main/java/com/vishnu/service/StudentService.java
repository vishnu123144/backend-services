package com.vishnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.exception.ResourceNotFoundException;
import com.vishnu.model.Student;
import com.vishnu.repo.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository repository;
	
	
	public Student saveStudentDetails(Student student) {
		return repository.save(student);
	}
	
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	
	public Object getStudentById(Long id) throws ResourceNotFoundException {
		 Student findById = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("student id not found"+id));
		 return findById;
	}
	
	public String deleteStudent(Long id) {
       repository.deleteById(id);
       return "student data deleted" +id;
	}
	
	public Student updateStudent(Student student) {
		Student existingStudent=repository.getById(student.getId());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setName(student.getName());
		existingStudent.setCity(student.getCity());
		return repository.save(existingStudent);
		
	}
}
