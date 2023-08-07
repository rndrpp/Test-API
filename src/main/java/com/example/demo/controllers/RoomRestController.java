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

import com.example.demo.entities.Room;
import com.example.demo.handler.Response;
import com.example.demo.services.RoomService;

@RestController
@RequestMapping("api")
public class RoomRestController {
    @Autowired
    private RoomService roomService;

    @GetMapping("room") // http://localhost:8088/api/room
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "retrieved", roomService.Get());
    }
    

    @GetMapping("room/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        return Response.generate(HttpStatus.OK, "retrieved", roomService.Get(id));
    }

    @PostMapping("room") // http://localhost:8088/api/room
    public ResponseEntity<Object> save(@RequestBody Room room){
        roomService.Save(room);
        return Response.generate(HttpStatus.OK, "saved");
    }

    @DeleteMapping("room/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        roomService.Delete(id);
        return Response.generate(HttpStatus.OK, "deleted");
    }
}
