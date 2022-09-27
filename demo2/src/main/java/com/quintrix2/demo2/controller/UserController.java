package com.quintrix2.demo2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix2.demo2.model.User;

@RestController
public class UserController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/home")
	public String hello() {
		return "Welcome, Demo2";
	}

	@RequestMapping(value = "home/user", method = RequestMethod.GET)
	public List<User> getUserList() {
		ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost:8080/home/user", List.class);
		List<User> users = responseEntity.getBody();
		return users;
	}
	
	@RequestMapping(value = "home/user", method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		HttpEntity<User> requestBody = new HttpEntity<User>(new User(user.getId(), user.getFirstName(), user.getLastName()));
		restTemplate.exchange("http://localhost:8080/home/user", HttpMethod.POST, requestBody, String.class);
	}
	
	@RequestMapping(value = "home/user", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
		HttpEntity<User> requestBody = new HttpEntity<User>(new User(user.getId(), user.getFirstName(), user.getLastName()));
		restTemplate.exchange("http://localhost:8080/home/user", HttpMethod.PUT, requestBody, String.class);
	}
	
	@RequestMapping(value = "home/user/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") int id) {
		restTemplate.delete("http://localhost:8080/home/user/{id}", id);
	}
	
}
