package com.brillio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brillio.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
	
	Student findByname(String name);
    Student findByCity(String city);
}
