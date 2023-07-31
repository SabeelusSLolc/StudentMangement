package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.RestTemplateService;

@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {
	
	@Autowired
	private RestTemplateService restTemplateService;
	
//	@GetMapping("/getAllBooks")
//	public ResponseEntity<String> allBooks(){
//		return restTemplateService.allBooks();
//	}
	
	
	@GetMapping("/getBooks")
	public List<Object> getAllBooks(){
		return restTemplateService.getBooks();
		
	}
	
	@GetMapping("/getSingleBook")
	public List<Object> getSingleBook(){
		return restTemplateService.getSingleBook();
	}
}
