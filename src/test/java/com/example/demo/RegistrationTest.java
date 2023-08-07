package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.services.RegistrationService;

@SpringBootTest
public class RegistrationTest {
    @Autowired
    private RegistrationService registrationService;

    @Test
    public void Save(){
        Boolean expected = true;

        com.example.demo.entities.Registration registration = new com.example.demo.entities.Registration();
        // registration.setRegistration_id(19);
        // registration.setStudent(25021839);
        // registration.setSchedule_id(4);
        registration.setStatus("Success");
        registration.setRegistration_time("2023-08-03 00:00:00");

        Boolean result = registrationService.Save(registration);

        assertEquals(expected, result);
    }

    @Test
    public void Delete(){
        Boolean expected = true;
        Integer registration_id = 15;

        Boolean result = registrationService.Delete(registration_id);

        assertEquals(expected, result);
    }
}
