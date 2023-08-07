package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
    
}
