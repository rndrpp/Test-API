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

import com.example.demo.entities.Faculty;
import com.example.demo.handler.Response;
import com.example.demo.services.FacultyService;

@RestController
@RequestMapping("api")
public class FacultyRestController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("faculty") // http://localhost:8088/api/faculty
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "retrieved", facultyService.Get());
    }
    

    @GetMapping("faculty/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        return Response.generate(HttpStatus.OK, "retrieved", facultyService.Get(id));
    }

    @PostMapping("faculty") // http://localhost:8088/api/faculty
    public ResponseEntity<Object> save(@RequestBody Faculty faculty){
        facultyService.Save(faculty);
        return Response.generate(HttpStatus.OK, "saved");
    }

    @DeleteMapping("faculty/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        facultyService.Delete(id);
        return Response.generate(HttpStatus.OK, "deleted");
    }
}
