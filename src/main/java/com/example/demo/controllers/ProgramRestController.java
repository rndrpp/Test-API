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

import com.example.demo.entities.Program;
import com.example.demo.handler.Response;
import com.example.demo.services.ProgramService;

@RestController
@RequestMapping("api")
public class ProgramRestController {
    @Autowired
    private ProgramService programService;

    @GetMapping("program") // http://localhost:8088/api/program
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "retrieved", programService.Get());
    }
    

    @GetMapping("program/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        return Response.generate(HttpStatus.OK, "retrieved", programService.Get(id));
    }

    @PostMapping("program") // http://localhost:8088/api/program
    public ResponseEntity<Object> save(@RequestBody Program program){
        programService.Save(program);
        return Response.generate(HttpStatus.OK, "saved");
    }

    @DeleteMapping("program/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        programService.Delete(id);
        return Response.generate(HttpStatus.OK, "deleted");
    }
}
