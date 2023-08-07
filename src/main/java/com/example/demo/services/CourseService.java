package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
import com.example.demo.services.generic.GenericServices;

@Service
public interface CourseService extends GenericServices<Course, Integer> {
    
}
