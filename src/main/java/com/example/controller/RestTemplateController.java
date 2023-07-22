package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public ResponseEntity<String> allBooks
}
