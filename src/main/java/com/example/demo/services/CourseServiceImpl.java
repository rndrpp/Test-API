package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
import com.example.demo.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> Get() {
        return courseRepository.findAll();
    }

    @Override
    public Course Get(Integer id) {
        return courseRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Course model) {
        courseRepository.save(model);
        return courseRepository.findById(model.getCourse_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        courseRepository.deleteById(id);
        return !courseRepository.findById(id).isPresent();
    }
}
