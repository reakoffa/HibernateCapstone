package com.securityex.SecurityDemo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "studentinfo")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "")
	private int id;
	private String fname;
	private String lname;
	private int phonenum;
	private String address;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "enrollment", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "courseid"))
	private Set<Course> course;

	public Student() {
		super();
	}

	public Student(int id, String fname, String lname, int phonenum, String address) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.phonenum = phonenum;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(int phonenum) {
		this.phonenum = phonenum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", phonenum=" + phonenum + ", address="
				+ address + "]";
	}

}
