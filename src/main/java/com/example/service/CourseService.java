package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CourseRepository;
import com.example.model.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Course CreateCourse(Course course) {
		return courseRepository.save(course);
		
	}
	
	public List<Course> createCourses(List<Course> Courses){
		return courseRepository.saveAll(Courses);
	}
	
	public Course getCourseById(int id) {
		return courseRepository.findById(id).orElse(null);
		
	}
	
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	public Course updateCourse(Course course) {
		Course oldCourse = null;
		Optional<Course> optionalCourse = courseRepository.findById(course.getId());
		if (optionalCourse.isPresent()) {
			oldCourse = optionalCourse.get();
			oldCourse.setName(course.getName());
			oldCourse.setDuration(course.getDuration());
			oldCourse.setDescription(course.getDescription());
			oldCourse.setFee(course.getFee());
			oldCourse.setStartDate(course.getStartDate());
			oldCourse.setEndDate(course.getEndDate());
			courseRepository.save(oldCourse);
		}
		else {
			return new Course();
		}
		
		return oldCourse;
	}
	
	public String deleteCourseById(int id) {
		courseRepository.deleteById(id);
		return "Course Deleted Successfully";
	}
}
