package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	
}
