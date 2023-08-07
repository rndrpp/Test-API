package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Lecturer;
import com.example.demo.services.LecturerService;

@Controller
@RequestMapping("lecturer") // http://localhost:8088/api/lecturer
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("lecturers", lecturerService.Get());
        return "lecturer/index";
    }

    // GET
    @GetMapping(value = { "form", "form/{id}" })
    public String form(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            model.addAttribute("lecturer", lecturerService.Get(id));
            
        } else {
            model.addAttribute("lecturer", new Lecturer());

        }
        return "lecturer/form";
    }

    // POST

    @PostMapping("save")
    public String submit(Lecturer lecturer) {
        Boolean result = lecturerService.Save(lecturer);
        if (result) {
            return "redirect:/lecturer";
        } else {
            return "lecturer/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        lecturerService.Delete(id);
        return "redirect:/lecturer";
    }
}
