package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Lecturer;
import com.example.demo.repositories.LecturerRepository;

@Service
public class LecturerServiceImpl implements LecturerService{
    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public List<Lecturer> Get() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer Get(Integer id) {
        return lecturerRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Lecturer model) {
        lecturerRepository.save(model);
        return lecturerRepository.findById(model.getLecturer_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        lecturerRepository.deleteById(id);
        return !lecturerRepository.findById(id).isPresent();
    }
}
