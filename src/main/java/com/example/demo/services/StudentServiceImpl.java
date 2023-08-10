package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> Get() {
        return studentRepository.findAll();
    }

    @Override
    public Student Get(Integer id) {
        return studentRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Student model) {
        studentRepository.save(model);
        return studentRepository.findById(model.getStudent_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        studentRepository.deleteById(id);
        return !studentRepository.findById(id).isPresent();
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Integer findIdByEmail(String email) {
        return studentRepository.findIdByEmail(email);
    }
}
