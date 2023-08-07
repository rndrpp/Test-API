package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    
}
