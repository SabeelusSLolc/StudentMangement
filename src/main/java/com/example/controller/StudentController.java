package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.model.StudentDto;
import com.example.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PostMapping("/createStudents")
	public List<Student> createStudents(@RequestBody List<Student> students) {
		return studentService.createStudents(students);
	}
	
	@PostMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/search/{firstName}")
	public List<Student> searchStudentsByFirstName(@PathVariable String firstName) {
		return studentService.searchStudentsByFirstName(firstName);
	}
	
	//studentDto getting limited details of student 
	@GetMapping("/studentDto/{studentId}")
	public StudentDto convertedDto(@PathVariable Student studentId) {
		return studentService.convertToDto(studentId);
	}

}

