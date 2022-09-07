package com.quintrix2.demo2.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.quintrix2.demo2.model.User;

@RestController
public class TestController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/home")
	public String hello() {
		return "Welcome, Demo2";
	}

	@RequestMapping(value = "home/user", method = RequestMethod.GET)
	public String getUserList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		
		return restTemplate.exchange("http://localhost:8080/home/user", HttpMethod.GET, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "home/user", method = RequestMethod.POST)
	public String createUser(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <User> entity = new HttpEntity<User>(user, headers);
		
		return restTemplate.exchange("http://localhost:8080/home/user", HttpMethod.POST, entity, String.class).getBody();
	}
	
}
