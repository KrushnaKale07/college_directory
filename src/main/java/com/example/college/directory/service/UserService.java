package com.example.college.directory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.college.directory.entity.User;
import com.example.college.directory.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	 public Optional<User> findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }

	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }
}
