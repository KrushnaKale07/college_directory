package com.example.college.directory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class StudentProfile {

	@Id
	private Long userId;

	private String photo;
	private String year;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StudentProfile() {
		super();
	}

	public StudentProfile(Long userId, String photo, String year, Department department, User user) {
		super();
		this.userId = userId;
		this.photo = photo;
		this.year = year;
		this.department = department;
		this.user = user;
	}

	@Override
	public String toString() {
		return "StudentProfile [userId=" + userId + ", photo=" + photo + ", year=" + year + ", user=" + user + "]";
	}
}
