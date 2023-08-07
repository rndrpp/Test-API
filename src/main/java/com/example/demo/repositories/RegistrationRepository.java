package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    
}
