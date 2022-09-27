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
import com.quintrix.demo.model.User;
import com.quintrix.demo.service.UserService;

@RestController
public class UserController {

  @Autowired
  UserService service;

  @GetMapping("/home")
  public String helloWorld() {
    return "Welcome, Demo";
  }

  @GetMapping("/home/user")
  public List<User> get() {
    return service.selectAll();
  }

  @GetMapping("/home/user/{id}")
  public User get(@PathVariable("id") int id) {
    return service.selectUser(id);
  }

  @PostMapping(params = {"id", "firstName", "lastName"}, value = "/home/user")
  public int post(@RequestParam int id, @RequestParam String firstName,
      @RequestParam String lastName) {
    return service.createUser(id, firstName, lastName);
  }

  @PostMapping("/home/user")
  public int post(@RequestBody User user) {
    return service.createUser(user);
  }

  @PutMapping(params = {"id", "firstName", "lastName"}, value = "/home/user")
  public int put(@RequestParam int id, @RequestParam String firstName,
      @RequestParam String lastName) {
    return service.updateUser(id, firstName, lastName);
  }

  @PutMapping("/home/user")
  public int put(@RequestBody User user) {
    return service.updateUser(user);
  }

  @DeleteMapping("/home/user/{id}")
  public int delete(@PathVariable("id") int id) {
    return service.deleteUser(id);
  }
}
