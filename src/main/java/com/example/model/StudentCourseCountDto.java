package com.example.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class StudentCourseCountDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentCount;
	private long courseCount;
	private long subjectCount;
	public long getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(long studentCount) {
		this.studentCount = studentCount;
	}
	public long getCourseCount() {
		return courseCount;
	}
	public void setCourseCount(long courseCount) {
		this.courseCount = courseCount;
	}
	public long getSubjectCount() {
		return subjectCount;
	}
	public void setSubjectCount(long subjectCount) {
		this.subjectCount = subjectCount;
	}
	
	
}
