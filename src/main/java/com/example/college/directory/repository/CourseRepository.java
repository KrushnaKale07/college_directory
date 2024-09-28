package com.example.college.directory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.college.directory.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
