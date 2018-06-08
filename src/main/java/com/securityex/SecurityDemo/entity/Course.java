package com.securityex.SecurityDemo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courseinfo")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseid;
	private String name;
	private String category;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "enrollment", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "courseid"))
	private Set<Student> student;
	
	
	public Course() {

	}

	public Course(int courseid, String name, String category) {
		super();
		this.courseid = courseid;
		this.name = name;
		this.category = category;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", name=" + name + ", category=" + category + "]";
	}

}
