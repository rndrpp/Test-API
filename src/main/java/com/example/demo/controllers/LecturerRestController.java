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

import com.example.demo.entities.Lecturer;
import com.example.demo.handler.Response;
import com.example.demo.services.LecturerService;

@RestController
@RequestMapping("api")
public class LecturerRestController {
    @Autowired
    private LecturerService lecturerService;

    @GetMapping("lecturer") // http://localhost:8088/api/lecturer
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "retrieved", lecturerService.Get());
    }
    

    @GetMapping("lecturer/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        return Response.generate(HttpStatus.OK, "retrieved", lecturerService.Get(id));
    }

    @PostMapping("lecturer") // http://localhost:8088/api/lecturer
    public ResponseEntity<Object> save(@RequestBody Lecturer lecturer){
        lecturerService.Save(lecturer);
        return Response.generate(HttpStatus.OK, "saved");
    }

    @DeleteMapping("lecturer/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        lecturerService.Delete(id);
        return Response.generate(HttpStatus.OK, "deleted");
    }
}
