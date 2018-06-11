package com.securityex.SecurityDemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityex.SecurityDemo.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Integer> {

//	Optional<Course> listAllCourses(String courseName);
//	
//	Optional<Course> listAllStudents(String student);
//	
//	List<Course> findByName(String name);
	
	
	
}
