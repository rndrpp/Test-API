package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Program;
import com.example.demo.repositories.ProgramRepository;

@Service
public class ProgramServiceImpl implements ProgramService{
    @Autowired
    private ProgramRepository programRepository;

    @Override
    public List<Program> Get() {
        return programRepository.findAll();
    }

    @Override
    public Program Get(Integer id) {
        return programRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Program model) {
        programRepository.save(model);
        return programRepository.findById(model.getProgram_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        programRepository.deleteById(id);
        return !programRepository.findById(id).isPresent();
    }
}
