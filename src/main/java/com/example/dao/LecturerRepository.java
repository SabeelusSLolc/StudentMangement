package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer>{
	
}
