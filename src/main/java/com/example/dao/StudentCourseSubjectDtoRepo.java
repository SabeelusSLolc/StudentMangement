package com.example.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.StudentCourseCountDto;
import com.example.model.StudentCourseSubjectDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class StudentCourseSubjectDtoRepo {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public StudentCourseSubjectDto getCourseSubjectDtoRepo(int studentId) {
        StudentCourseSubjectDto studentCourseSubjectDto = new StudentCourseSubjectDto();

		Query query = entityManager.createQuery("SELECT s.id, s.firstName FROM Student s WHERE s.id = :studentId");
		query.setParameter("studentId", studentId);
		List<Object[]> result = query.getResultList();
		if (!result.isEmpty()) {
            Object[] row = result.get(0);
            studentCourseSubjectDto.setId((int) row[0]);
            studentCourseSubjectDto.setFullname((String) row[1]);
//            studentCourseSubjectDto.setCourses((List<Course>) row[2]);
//            studentCourseSubjectDto.setSubjects((List<Subject>) row[3]);
        }
         
        return studentCourseSubjectDto;
    }
	
	public StudentCourseCountDto getCount() {
		
		StudentCourseCountDto studentCourseCountDto = new StudentCourseCountDto();
		
		Query query = entityManager.createQuery("SELECT COUNT(s.id) from Student s");
		long studentCount = (long) query.getSingleResult();
		
		query = entityManager.createQuery("SELECT COUNT(c.id) From Course c");
		long  courseCount = (long) query.getSingleResult();
		
		query = entityManager.createQuery("SELECT COUNT(sb.id) FROM Subject sb");
		long subjectCount = (long) query.getSingleResult();
		
		studentCourseCountDto.setStudentCount(studentCount);
		studentCourseCountDto.setCourseCount(courseCount);
		studentCourseCountDto.setSubjectCount(subjectCount);
		
		return studentCourseCountDto;
		
	}
	}
