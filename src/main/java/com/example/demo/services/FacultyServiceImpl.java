package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Faculty;
import com.example.demo.repositories.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> Get() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty Get(Integer id) {
        return facultyRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Faculty model) {
        facultyRepository.save(model);
        return facultyRepository.findById(model.getFaculty_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        facultyRepository.deleteById(id);
        return !facultyRepository.findById(id).isPresent();
    }
}
