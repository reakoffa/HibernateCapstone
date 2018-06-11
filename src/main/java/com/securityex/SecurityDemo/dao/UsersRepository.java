package com.securityex.SecurityDemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityex.SecurityDemo.entity.Course;
import com.securityex.SecurityDemo.entity.Student;
import com.securityex.SecurityDemo.entity.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String name);

//	Optional<Student> findByLastName(String lastName);
//
//	Optional<Course> listAllStudents(Student student);

}
