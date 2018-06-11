package com.securityex.SecurityDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enrollment")
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int courseid;
	private String semester;
	private String grade;
//	private Student student;
//	private Course course;

	public Enrollment() {

	}

	public Enrollment(int id, int courseid, String semester, String grade) {
		super();
		this.id = id;
		this.courseid = courseid;
		this.semester = semester;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

//	public Course getCourse() {
//		return course;
//	}
//
//	public void setCourse(Course course) {
//		this.course = course;
//	}

	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", courseid=" + courseid + ", semester=" + semester + ", grade=" + grade + "]";
	}

}
