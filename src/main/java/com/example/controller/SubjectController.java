package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Subject;
import com.example.service.SubjectService;

@RestController
@RequestMapping(path ="/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/addSubject")
	public Subject addSubject(@RequestBody Subject subject) {
		return subjectService.createSubject(subject);
	}
	
	@PostMapping("/addSubjects")
	public List<Subject> addSubjects(@RequestBody List<Subject> subjects) {
		return subjectService.createSubjects(subjects);
	}
	
	@GetMapping("/getAllSubjects")
	public List<Subject> getAllSubjects() {
		return subjectService.getAllSubject();
	}
	
	@PutMapping("/Update")
	public Subject update(@RequestBody Subject subject) {
		return subjectService.editSubjectById(subject);
	}
	
	@GetMapping("/{id}")
	public Subject getSubjectById(@PathVariable int id) {
		return subjectService.getSubjectById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteSubject(@PathVariable int id) {
		return subjectService.deleteSubjectById(id);
	}
	
	@DeleteMapping("/{subjectId}/courses/{courseId}")
	public Subject removeSubjectFromCourse(@PathVariable int subjectId, @PathVariable int courseId) {
		// Call the service method to remove the subject from the course
		return subjectService.removeSubjectFromCourse(subjectId, courseId);
	}
}
