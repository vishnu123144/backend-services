package com.brillio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.model.Student;
import com.brillio.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	
	private StudentRepository repository;
	
	public Student saveStudentDetails(Student student)
	{
		return repository.save(student);
	}
	
	public List<Student> getStudentDetails()
	{
		return repository.findAll();
	}
	public Student findStudentById(Long id)
	{
		Optional<Student> find=repository.findById(id);
		if(find.isPresent())
		{
			return find.get();
		}else
		{
			return null;
		}
	}
	public Student findStudentByName(String name)
	{
		return repository.findByname(name);
	}
	
	public void deleteLaptop(Student student)
	{
		repository.delete(student);
	}

}
