package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Schedule;
import com.example.demo.services.GroupService;
import com.example.demo.services.RoomService;
import com.example.demo.services.ScheduleService;

@Controller
@RequestMapping("schedule") // http://localhost:8088/api/schedule
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private RoomService roomService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("schedules", scheduleService.Get());
        return "schedule/index";
    }

    // GET
    @GetMapping(value = { "form", "form/{id}" })
    public String form(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            model.addAttribute("groups", groupService.Get());
            model.addAttribute("rooms", roomService.Get());
            model.addAttribute("schedule", scheduleService.Get(id));
            
        } else {
            model.addAttribute("groups", groupService.Get());
            model.addAttribute("rooms", roomService.Get());
            model.addAttribute("schedule", new Schedule());
            

        }
        return "schedule/form";
    }

    // POST

    @PostMapping("save")
    public String save(Schedule schedule) {
        Boolean result = scheduleService.Save(schedule);
        if (result) {
            return "redirect:/schedule";
        } else {
            return "schedule/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        scheduleService.Delete(id);
        return "redirect:/schedule";
    }
}
