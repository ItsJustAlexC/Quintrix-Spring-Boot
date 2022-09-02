package com.quintrix.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quintrix.demo.model.User;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}

	@PostMapping("/rParam")
	public User Display(@RequestParam String firstName, @RequestParam String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return user;
	}

	@PostMapping("/rPath/{id}")
	public User Display(@PathVariable("id") String id) {
		User user = new User();
		String name = "";
		switch (id) {
		case "1":
			name = "John Doe";
			break;
		case "2":
			name = "Richard Adams";
			break;
		case "3":
			name = "Steve Smith";
			break;
		}

		if (id != null) {
			int space = name.indexOf(" ");
			user.setFirstName(name.substring(0, space));
			user.setLastName(name.substring(space + 1, name.length()));
		}

		return user;

	}

	@PostMapping("/rBody")
	public User Display(@RequestBody User input) {
		User user = new User();
		user.setFirstName(input.getFirstName());
		user.setLastName(input.getLastName());
		return user;
	}
}
