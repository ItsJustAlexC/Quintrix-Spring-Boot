package com.quintrix.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quintrix.demo.dao.UserDao;
import com.quintrix.demo.model.User;

@RestController
public class HelloController {

	@Autowired
	UserDao dao;

	@GetMapping("/home")
	public String helloWorld() {
		return "Welcome, Test Page";
	}

	@GetMapping("/home/user")
	public List<User> get() {
		return dao.selectAll();
	}

	@GetMapping("/home/user/{id}")
	public User get(@PathVariable("id") int id) {
		return dao.selectUser(id);
	}

	@PostMapping(params = { "id", "firstName", "lastName" }, value = "/home/user")
	public int post(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
		return dao.createUser(id, firstName, lastName);
	}

	@PostMapping("/home/user")
	public int post(@RequestBody User user) {
		return dao.createUser(user);
	}

	@PutMapping(params = { "id", "firstName", "lastName" }, value = "/home/user")
	public int put(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
		return dao.updateUser(id, firstName, lastName);
	}

	@PutMapping("/home/user")
	public int put(@RequestBody User user) {
		return dao.updateUser(user);
	}

	@DeleteMapping("/home/user/{id}")
	public int delete(@PathVariable("id") int id) {
		return dao.deleteUser(id);
	}
}
