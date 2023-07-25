package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RestTemplateService {

    RestTemplate restTemplate = new RestTemplate();

    private static final String get_All_Books = "https://openlibrary.org/dev/docs/api/books";

//    public ResponseEntity<String> allBooks() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        // Add other headers if needed
//        // headers.add("Authorization", headerValue);
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(get_All_Books, HttpMethod.GET, entity, String.class);
//        return response;
//    }
    
    
    public List<Object> getBooks(){
		Object[] objects = new Object[] {restTemplate.getForObject(get_All_Books, Object.class)};
    	return Arrays.asList(objects);
    }
}
