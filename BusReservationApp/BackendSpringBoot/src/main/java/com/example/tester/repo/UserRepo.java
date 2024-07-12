package com.example.tester.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tester.entity.User;


public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	  User findByEmail(String email);
	
	

}
