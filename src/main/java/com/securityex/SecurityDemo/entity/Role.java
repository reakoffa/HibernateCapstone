package com.securityex.SecurityDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	// Variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleid;
	private String role;

	// Constructors
	public Role() {

	}

	// Getters and setters
	public int getRoleiId() {
		return roleid;
	}

	public void setRoleId(int roleid) {
		this.roleid = roleid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
