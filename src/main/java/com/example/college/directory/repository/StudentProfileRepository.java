package com.example.college.directory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.college.directory.entity.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

}
