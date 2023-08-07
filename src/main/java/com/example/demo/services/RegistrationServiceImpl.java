package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Registration;
import com.example.demo.repositories.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public List<Registration> Get() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration Get(Integer id) {
        return registrationRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Registration model) {
        registrationRepository.save(model);
        return registrationRepository.findById(model.getRegistration_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        registrationRepository.deleteById(id);
        return !registrationRepository.findById(id).isPresent();
    }
}
