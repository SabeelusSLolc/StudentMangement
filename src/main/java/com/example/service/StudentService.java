package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CourseRepository;
import com.example.dao.StudentRepository;
import com.example.dao.SubjectRepository;
import com.example.model.Course;
import com.example.model.Student;
import com.example.model.StudentCourseSubjectDto;
import com.example.model.StudentDto;
import com.example.model.Subject;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
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
	
	//studentDto class limited details
	public StudentDto convertToDto(Student student) {
		StudentDto dto = new StudentDto();
		dto.setFullname(student.getFirstName() + " " + student.getLastName());
		dto.setAddress(student.getAddress());
		dto.setPhone_number(student.getPhoneNumber());
		return dto;
	}
	
//	public StudentCourseSubjectDto getStudentCourseSubjectDetails(int StudentId) {
//		Student student = studentRepository.findById(StudentId).orElse(null);
//		if(student != null) {
//			String firstName = student.getFirstName();
//			List<Course> courses = courseRepository.findCoursesByStudentsId(StudentId);
//			//List<Subject> subjects = subjectRepository.findSubjectsByLecturersId(StudentId);
//			StudentCourseSubjectDto dto = new StudentCourseSubjectDto(StudentId, firstName, courses);
//			return dto;
//		}else {
//			return null;
//		}
//	}
	
//	public List<StudentCourseSubjectDto> getStudentCourseSubjectDetails(){
//		Student student = new Student();
//		Course course = new Course();
//		StudentCourseSubjectDto dto2 = new StudentCourseSubjectDto();
//		dto2.setId(student.getId());
//		dto2.setCourses(course.getName());
//	}
//	
	
	
	
	
	
}
