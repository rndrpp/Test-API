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

import com.example.demo.entities.Course;
import com.example.demo.handler.Response;
import com.example.demo.services.CourseService;

@RestController
@RequestMapping("api")
public class CourseRestController {
    @Autowired
    private CourseService courseService;

    @GetMapping("course") // http://localhost:8088/api/course
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "retrieved", courseService.Get());
    }
    

    @GetMapping("course/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        return Response.generate(HttpStatus.OK, "retrieved", courseService.Get(id));
    }

    @PostMapping("course") // http://localhost:8088/api/course
    public ResponseEntity<Object> save(@RequestBody Course course){
        courseService.Save(course);
        return Response.generate(HttpStatus.OK, "saved");
    }

    @DeleteMapping("course/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        courseService.Delete(id);
        return Response.generate(HttpStatus.OK, "deleted");
    }
}
