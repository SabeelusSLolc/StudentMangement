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

import com.example.model.Lecturer;
import com.example.service.LecturerService;

@RestController
@RequestMapping(path = "/lecturer")
public class LecturerController {
	
	@Autowired
	private LecturerService lecturerService;
	
	@PostMapping("/addLecturer")
	public Lecturer addLecturer(@RequestBody Lecturer lecturer) {
		return lecturerService.createLecturer(lecturer);
	}
	
	@PostMapping("/addLecturers")
	public List<Lecturer> addLecturers(@RequestBody List<Lecturer> lecturers) {
		return lecturerService.createLecturers(lecturers);
	}
	
	@PutMapping("/updateLecturer")
	public Lecturer updateLecturer(@RequestBody Lecturer lecturer) {
		return lecturerService.updateLecturer(lecturer);
	}
	
	@DeleteMapping("/{id}")
	public String deleteLecturer (@PathVariable int id) {
		return lecturerService.deleteLecturer(id);
	}
	
	@GetMapping("/getAllLecturers")
	public List<Lecturer> getAllLecturers() {
		return lecturerService.getAllLecturers();
	}
	
	@GetMapping("/{id}")
	public Lecturer getLecturerById(@PathVariable int id) {
		return lecturerService.getLecturerById(id);
	}
}
