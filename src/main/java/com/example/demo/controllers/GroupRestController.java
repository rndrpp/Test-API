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

import com.example.demo.entities.Group;
import com.example.demo.handler.Response;
import com.example.demo.services.GroupService;

@RestController
@RequestMapping("api")
public class GroupRestController {
    @Autowired
    private GroupService groupService;

    @GetMapping("group") // http://localhost:8088/api/group
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "retrieved", groupService.Get());
    }
    

    @GetMapping("group/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        return Response.generate(HttpStatus.OK, "retrieved", groupService.Get(id));
    }

    @PostMapping("group") // http://localhost:8088/api/group
    public ResponseEntity<Object> save(@RequestBody Group group){
        groupService.Save(group);
        return Response.generate(HttpStatus.OK, "saved");
    }

    @DeleteMapping("group/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        groupService.Delete(id);
        return Response.generate(HttpStatus.OK, "deleted");
    }
}
