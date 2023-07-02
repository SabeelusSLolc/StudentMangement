package com.example.model;

import java.util.HashSet;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;
	    private String description;
	    private double fee;
	    private int duration;
	    private String startDate;
	    private String endDate;
	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	    		name = "Course_Subject",
	    		joinColumns = @JoinColumn(name = "course_id"), //the owning side
	    		inverseJoinColumns = @JoinColumn(name = "subject_id")) //the non-owning (inverse side)
	    @JsonProperty("subjects")
	    private Set<Subject> subjects = new HashSet<>();
	    
	    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Enrollment> enrollments = new HashSet<>();
	    //nothing will be modified in the database in the course_subject
	    
	    
	    public Set<Subject> getSubjects() {
			return subjects;
		}
	    
		public Set<Enrollment> getEnrollments() {
			return enrollments;
		}
		//enrollStudent
		public void enrollStudent(Student student) {
		    // Check if the student is already enrolled in the course
		    for (Enrollment enrollment : enrollments) {
		        if (enrollment.getStudent().equals(student)) {
		            return; // Student is already enrolled, exit the method
		        }
		    }

		    // Create the enrollment and add it to the sets
		    Enrollment enrollment = new Enrollment(this, student);
		    enrollments.add(enrollment);
		    student.getEnrollments().add(enrollment);
		}

		public void unenrollStudent(Student student) {
	        Enrollment enrollmentToRemove = null;
	        for (Enrollment enrollment : enrollments) {
	            if (enrollment.getCourse().equals(this) && enrollment.getStudent().equals(student)) {
	                enrollmentToRemove = enrollment;
	                break;
	            }
	        }
	        if (enrollmentToRemove != null) {
	            enrollments.remove(enrollmentToRemove);
	            student.getEnrollments().remove(enrollmentToRemove);
	        }
	    }
		
		public void addSubject(Subject subject) {
			this.subjects.add(subject);
			subject.getCourses().add(this);
		}
		
		public void removeSubject(long subjectId) {
		    Subject subject = this.subjects.stream().filter(s -> s.getId() == subjectId).findFirst().orElse(null);
		    if (subject != null) {
		      this.subjects.remove(subject);
		      subject.getCourses().remove(this);
		    }
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getFee() {
			return fee;
		}
		public void setFee(double fee) {
			this.fee = fee;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		
		public void setSubjects(Set<Subject> subjects) {
	        this.subjects = subjects;
	    }

	
}
