package com.example.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Subject_Lecturer",
	joinColumns = @JoinColumn(name = "subject_id"), //owning side
	inverseJoinColumns = @JoinColumn(name = "lecturer_id"))
	
	private Set<Lecturer> lecturers = new HashSet<>();	
	
	
	public Set<Lecturer> getLecturers() {
		return lecturers;
	}
	public void addLecturer(Lecturer lecturer) {
		this.lecturers.add(lecturer);
		lecturer.getSubjects().add(this);
	}
	public void removeLecturer(int lecturerId) {
		Lecturer lecturer = this.lecturers.stream().filter(s -> s.getId() == lecturerId).findFirst().orElse(null);
		if(lecturer!= null) {
			this.lecturers.remove(lecturer);
			lecturer.getSubjects().remove(this);
		}
	}
	public Set<Course> getCourses() {
		return courses;
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
