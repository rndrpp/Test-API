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

import com.example.demo.entities.Schedule;
import com.example.demo.handler.Response;
import com.example.demo.services.ScheduleService;

@RestController
@RequestMapping("api")
public class ScheduleRestController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("schedule") // http://localhost:8088/api/schedule
    public ResponseEntity<Object> get(){
        return Response.generate(HttpStatus.OK, "retrieved", scheduleService.Get());
    }
    

    @GetMapping("schedule/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id){
        return Response.generate(HttpStatus.OK, "retrieved", scheduleService.Get(id));
    }

    @PostMapping("schedule") // http://localhost:8088/api/schedule
    public ResponseEntity<Object> save(@RequestBody Schedule schedule){
        scheduleService.Save(schedule);
        return Response.generate(HttpStatus.OK, "saved");
    }

    @DeleteMapping("schedule/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(required = true)Integer id){
        scheduleService.Delete(id);
        return Response.generate(HttpStatus.OK, "deleted");
    }
}
