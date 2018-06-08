package com.securityex.SecurityDemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securityex.SecurityDemo.dao.UsersRepository;
import com.securityex.SecurityDemo.entity.CustomUserDetails;
import com.securityex.SecurityDemo.entity.Student;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Student> o = usersRepository.findByName(username);
		
		//this is similar to checking for aull value
		o.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		
		//if the user is present then apply the associated mapping to it
		return o.map(CustomUserDetails :: new).get();
	}

	
}
