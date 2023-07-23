package com.example.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RestTemplateService {

    RestTemplate restTemplate = new RestTemplate();

    private static final String get_All_Books = "http://openlibrary.org/api/books?jscmd=data&bibkeys=ISBN:0201558025&format=json";

    public ResponseEntity<String> allBooks() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // Add other headers if needed
        // headers.add("Authorization", headerValue);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(get_All_Books, HttpMethod.GET, entity, String.class);
        return response;
    }
}
