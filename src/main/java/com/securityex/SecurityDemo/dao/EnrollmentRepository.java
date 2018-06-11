package com.securityex.SecurityDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityex.SecurityDemo.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
	
	List<Enrollment> findById(int id);
	

}
