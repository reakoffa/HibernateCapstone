package com.securityex.SecurityDemo.entity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails extends Student implements UserDetails {

	//create a custom constructor for the copying constructor from users
	public CustomUserDetails(final Student u) {
		super();
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//this will be for assigning the roles for authorization to certain pages
		// using SimpleGrantedAuthority that is built into ApringSecurity using the stream api
		
		return getRole().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {	
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
