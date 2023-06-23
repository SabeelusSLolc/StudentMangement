package com.example.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String Description;
	
	@ManyToMany(mappedBy = "subjects")
	private Set<Course> courses;
	
	@ManyToMany(mappedBy = "subjects")
	private List<Lecturer> lecturers;
	
	public Set<Course> getCourses() {
		return courses;
	}
	public List<Lecturer> getLecturers() {
		return lecturers;
	}
	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
