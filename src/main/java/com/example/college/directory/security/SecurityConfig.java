package com.example.college.directory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().requestMatchers("/api/auth/**").permitAll()
				.requestMatchers("/api/student/**").hasRole("STUDENT").requestMatchers("/api/faculty/**")
				.hasRole("FACULTY_MEMBER").requestMatchers("/api/admin/**").hasRole("ADMINISTRATOR").anyRequest()
				.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return http.build();
	}
}
