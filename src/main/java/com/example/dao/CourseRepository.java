package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Course;
import com.example.model.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
	
	//List<Student> findByStudentsId(String studentid);
	
}
