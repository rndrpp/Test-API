package com.example.demo.services;

import com.example.demo.entities.Student;
import com.example.demo.services.generic.GenericServices;

public interface StudentService extends GenericServices<Student, Integer> {
    public Integer findIdByEmail(String email);
}
