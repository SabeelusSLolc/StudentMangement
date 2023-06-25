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
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Subject createSubject(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	public List<Subject> createSubjects(List<Subject> subject) {
		return subjectRepository.saveAll(subject);
	}
	
	public List<Subject> getAllSubject(){
		return subjectRepository.findAll();
	}
	
	public List<Subject> getAllSubjectByCourseid(int subjectid){
		return subjectRepository.findAll();
	}
	
	public Subject getSubjectById(int id) {
		return subjectRepository.findById(id).orElse(null);
	}
	
	public String deleteSubjectById(int id) {
		subjectRepository.deleteById(id);
		return "Succesfully Deleted";
	}
	
	public Subject editSubjectById(Subject subject) {
		Subject oldSubject=null;
		Optional<Subject> optionalSubject = subjectRepository.findById(subject.getId());
		if(optionalSubject.isPresent()) {
			oldSubject = optionalSubject.get();
			oldSubject.setName(subject.getName());
			oldSubject.setDescription(subject.getDescription());
			subjectRepository.save(oldSubject);
		}
		else {
			return new Subject();
		}
		
		return oldSubject;
	}
	
	 public void enrollSubjectToCourse(int courseId, Subject subject) {
	        Optional<Course> optionalCourse = courseRepository.findById(courseId);
	        if (optionalCourse.isPresent() && optionalCourse.isPresent()) {
	            Course course = optionalCourse.get();
	            course.addSubject(subject);;
	            courseRepository.save(course);
	        }
	 }
	
}
