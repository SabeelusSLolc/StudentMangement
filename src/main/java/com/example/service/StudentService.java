package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CourseRepository;
import com.example.dao.StudentRepository;
import com.example.model.Course;
import com.example.model.Enrollment;
import com.example.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> createStudents(List<Student> students) {
		return studentRepository.saveAll(students);
	}
	
	public Student updateStudent(Student student) {
		Student oldStudent = null;
		Optional<Student> optionalStudent = studentRepository.findById(student.getId());
		 if (optionalStudent.isPresent()) {
		        oldStudent = optionalStudent.get();
		        oldStudent.setFirstName(student.getFirstName());
		        oldStudent.setLastName(student.getLastName());
		        oldStudent.setAddress(student.getAddress());
		        oldStudent.setPhoneNumber(student.getPhoneNumber());
		        oldStudent.setEmail(student.getEmail());
		        oldStudent.setNic(student.getNic());
		        oldStudent.setGender(student.getGender());
		        oldStudent.setDateOfBirth(student.getDateOfBirth());
		        studentRepository.save(oldStudent);
		    } else {
		        return new Student();
		    }
		    return oldStudent;
		}
	
	public String deleteStudent (int id) {
		studentRepository.deleteById(id);;
		return "Successfully Deleted";
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public List<Student> searchStudentsByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}
	
//	public Student getStudentDetails(int studentId) {
//	    Optional<Student> optionalStudent = studentRepository.findById(studentId);
//	    if (optionalStudent.isPresent()) {
//	        Student student = optionalStudent.get();
//	        Set<Enrollment> enrollments = student.getEnrollments();
//	        for (Enrollment enrollment : enrollments) {
//	            Course course = enrollment.getCourse();
//	            Set<Subject> subjects = course.getSubjects();
//	            course.setSubjects(subjects); // Set the subjects for the course
//	        }
//	        return student;
//	    }
//	    return null; // Handle the case when student is not found
//	}
	
	
//	public Course getCourseDetailsByStudentId(int studentid){
//		return courseRepository.findCourseByStudentId(studentid);
//	}
 
	
}
