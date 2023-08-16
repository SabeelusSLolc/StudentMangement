package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentCourseSubjectDtoRepo;
import com.example.model.StudentCourseCountDto;
import com.example.model.StudentCourseSubjectDto;

@Service
public class StudentCourseSubjectDtoService {
	
	@Autowired
	StudentCourseSubjectDtoRepo studentCourseSubjectDtoRepo;
	
	public StudentCourseSubjectDto getDetails(int id) {
		return studentCourseSubjectDtoRepo.getCourseSubjectDtoRepo(id);
	}
	
	public StudentCourseCountDto getCount() {
		return studentCourseSubjectDtoRepo.getCount();
	}
	
}
