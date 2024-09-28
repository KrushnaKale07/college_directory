package com.example.college.directory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.college.directory.entity.JwtResponse;
import com.example.college.directory.entity.LoginRequest;
import com.example.college.directory.entity.User;
import com.example.college.directory.security.JwtUtil;
import com.example.college.directory.service.UserService;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		User user = userService.findByUsername(request.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));

		if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			String token = jwtUtil.generateToken(user.getUsername());
			return ResponseEntity.ok(new JwtResponse(token, user.getRole()));
		} else {
			return ResponseEntity.status(401).body("Invalid credentials");
		}
	}
}
