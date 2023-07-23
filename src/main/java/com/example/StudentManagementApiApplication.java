package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.AdminRepository;
import com.example.model.Admin;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class StudentManagementApiApplication {
	
//	@Autowired
//	private AdminRepository repository;
//	
//	@PostConstruct
//	public void initAdmins() {
//		List<Admin> admins = Stream.of(
//				new Admin(101,"user1","pwd1","user1@gmail.com"),
//				new Admin(102,"user2","pwd2","user2@gmail.com"),
//				new Admin(103,"user3","pwd3","user3@gmail.com")).collect(Collectors.toList());
//		repository.saveAll(admins);
//	}
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApiApplication.class, args);
	}

}
