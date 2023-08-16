package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StudentCourseCountDto;
import com.example.model.StudentCourseSubjectDto;
import com.example.service.StudentCourseSubjectDtoService;

@RestController
@RequestMapping("/StudentCourseSubjectDto")
public class StudentCourseSubjectDtoController {
	
	@Autowired
	StudentCourseSubjectDtoService studentCourseSubjectDtoService;
	
	@GetMapping("/details/{id}")
    public StudentCourseSubjectDto getDetailss(@PathVariable int id) {
        return studentCourseSubjectDtoService.getDetails(id);
    }
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public StudentCourseCountDto getCount() {
		return studentCourseSubjectDtoService.getCount();
	}
}
