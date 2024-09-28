package com.example.college.directory.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
	private String secret = "secret_key";

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public Claims extractClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	public boolean isTokenValid(String token, String username) {
		String extractedUsername = extractClaims(token).getSubject();
		return (username.equals(extractedUsername) && !isTokenExpired(token));
	}

	public boolean isTokenExpired(String token) {
		return extractClaims(token).getExpiration().before(new Date());
	}
}
