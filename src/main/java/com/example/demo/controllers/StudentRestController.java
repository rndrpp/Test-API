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

import com.example.demo.entities.Student;
import com.example.demo.handler.Response;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("api")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("student") // http://localhost:8088/api/student
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "retrieved", studentService.Get());
    }
    

    @GetMapping("student/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        return Response.generate(HttpStatus.OK, "retrieved", studentService.Get(id));
    }

    @PostMapping("student") // http://localhost:8088/api/student
    public ResponseEntity<Object> save(@RequestBody Student student){
        studentService.Save(student);
        return Response.generate(HttpStatus.OK, "saved");
    }

    @DeleteMapping("student/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        studentService.Delete(id);
        return Response.generate(HttpStatus.OK, "deleted");
    }
}
