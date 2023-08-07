package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Registration;
import com.example.demo.handler.Response;
import com.example.demo.services.RegistrationService;

@RestController
@RequestMapping("api")
public class RegistrationRestController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("registration") // http://localhost:8088/api/registration
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "retrieved", registrationService.Get());
    }
    

    @GetMapping("registration/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        return Response.generate(HttpStatus.OK, "retrieved", registrationService.Get(id));
    }

    @PostMapping("registration") // http://localhost:8088/api/registration
    public ResponseEntity<Object> save(@RequestBody Registration registration){
        registrationService.Save(registration);
        return Response.generate(HttpStatus.OK, "saved");
    }

    @DeleteMapping("registration/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        registrationService.Delete(id);
        return Response.generate(HttpStatus.OK, "deleted");
    }
}
