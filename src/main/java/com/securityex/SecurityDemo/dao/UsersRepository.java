package com.securityex.SecurityDemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityex.SecurityDemo.entity.Movies;

public interface UsersRepository extends JpaRepository<Student, Integer>{

	Optional<Student> findByName(String username);
	
	Optional<Movies> findByLastName(String lastName);
	
	Optional<Movies> findByEmail(String email);
	
	
}
