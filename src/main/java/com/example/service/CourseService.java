package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CourseRepository;
import com.example.dao.SubjectRepository;
import com.example.model.Course;
import com.example.model.Subject;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	
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
		return "Successfully Deleted";
	}
	
	//assign subjects to the course
	public Course assignSubjectToCourse (int courseId, int subjectId) {
		Optional<Course> optionalCourse = courseRepository.findById(courseId);
		Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
		
		if(optionalCourse.isPresent() && optionalSubject.isPresent()) {
			Course course = optionalCourse.get();
			Subject subject = optionalSubject.get();
			
			course.getSubjects().add(subject);
			subject.getCourses().add(course);
			
			courseRepository.save(course);
			subjectRepository.save(subject);
			return course;
			
		}
		return null;
	}
	
	//remove subject from the course
	public Course removeSubjectFromCourse(int courseId, int subjectId) {
		Optional<Course> optionalCourse = courseRepository.findById(courseId);
		Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
		
		if (optionalCourse.isPresent() && optionalSubject.isPresent()) {
			Course course = optionalCourse.get();
			Subject subject = optionalSubject.get();
			
			course.getSubjects().remove(subject);
			subject.getCourses().remove(course);
			
			courseRepository.save(course);
			subjectRepository.save(subject);
			
			return course;
		}
		
		return null;
	}
}
