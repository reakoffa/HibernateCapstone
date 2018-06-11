package com.securityex.SecurityDemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityex.SecurityDemo.entity.Student;

public interface StudentRepository extends JpaRepository <Student, Integer> {
	
//	Optional<Student> findByName(String fname);
//	
//	Optional<Student> listAllCourses(String course);
	
	
	

	
}
