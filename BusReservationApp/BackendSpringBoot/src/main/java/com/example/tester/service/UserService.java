package com.example.tester.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tester.entity.User;
import com.example.tester.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public User createUser(User user) {
		return userRepo.save(user);
	}

	public User getUser(int id) {
        Optional<User> userOptional = userRepo.findById(id);
        return userOptional.orElse(null); // Return user if found, otherwise null
    }

//	public User login(String username, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

	public List<User> getAllUsers() {
		 return userRepo.findAll();
	
	}
	

}
