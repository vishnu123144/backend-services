package com.vishnu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishnu.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
