package com.example.tester.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tester.dto.LoginRequest;
import com.example.tester.dto.LoginResponse;
import com.example.tester.entity.Bus;
import com.example.tester.entity.User;
import com.example.tester.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
        return userService.getAllUsers();
	}
	
	@PostMapping("/register")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }
    
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        LoginResponse response = new LoginResponse();
        if (user != null) {
            if ("admin@gmail.com".equals(user.getEmail())) {
            	System.out.println("admin login successs");
                response.setNextPage("adminPage");
            } else {
            	System.out.println("User login successs");
                response.setNextPage("userPage");
            }
            response.setUser(user);
        } else {
        	System.out.println("UNsuccesss");
            response.setNextPage("loginFailed");
        }
        return response;
    }
	
	

}
