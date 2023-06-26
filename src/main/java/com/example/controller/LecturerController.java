package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Lecturer;
import com.example.model.Subject;
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
	
//	@GetMapping("/getAllLecturers")
//	public List<Lecturer> getAllLecturers() {
//		return lecturerService.getAllLecturers();
//	}
	
	@GetMapping("/lecturers/{lecturerId}/subjects")
	public List<Subject> getAllSubjectsByLecturerId(@PathVariable int lecturerId) {
		return lecturerService.getAllSubjectsByLecturerId(lecturerId);
	}
	
	@GetMapping("/{id}")
	public Lecturer getLecturerById(@PathVariable int id) {
		return lecturerService.getLecturerById(id);
	}
	
	@PostMapping("/subjects/{subjectId}/lecturers")
	public ResponseEntity<String> assignLecturerToSubject(@PathVariable int subjectId, @RequestBody Lecturer lecturer){
		lecturerService.assignLecturerToSubject(subjectId, lecturer);
		return ResponseEntity.ok("Succesfully assigned");
	}
	
	@DeleteMapping("/{subjectId}/lecturers/{lecturerId}")
	public ResponseEntity<HttpStatus> removeLecturerFromSubject(@PathVariable int subjectId,@PathVariable int lecturerId){
		lecturerService.removelecturerFromSubject(subjectId, lecturerId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	
}
