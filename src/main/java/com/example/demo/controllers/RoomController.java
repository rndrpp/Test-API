package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Room;
import com.example.demo.services.RoomService;

@Controller
@RequestMapping("room") // http://localhost:8088/api/room
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("rooms", roomService.Get());
        return "room/index";
    }

    // GET
    @GetMapping(value = { "form", "form/{id}" })
    public String form(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            model.addAttribute("room", roomService.Get(id));
            
        } else {
            model.addAttribute("room", new Room());

        }
        return "room/form";
    }

    // POST

    @PostMapping("save")
    public String submit(Room room) {
        Boolean result = roomService.Save(room);
        if (result) {
            return "redirect:/room";
        } else {
            return "room/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        roomService.Delete(id);
        return "redirect:/room";
    }
}
