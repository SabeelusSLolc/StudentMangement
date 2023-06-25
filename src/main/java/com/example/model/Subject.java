package com.example.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	
	@ManyToMany(
			fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST,
					CascadeType.MERGE
					},
			mappedBy = "subjects"
					  )
	@JsonIgnore//So, the side which doesn’t have the mappedBy attribute is the owner, the side which has the mappedBy attribute is the inverse side.
	private Set<Course> courses = new HashSet<>();
	//if you add anything here row will be inserted by Hibernate in the join table
	
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
