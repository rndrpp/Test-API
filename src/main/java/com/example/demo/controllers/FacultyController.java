package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Faculty;
import com.example.demo.services.FacultyService;

@Controller
@RequestMapping("faculty") // http://localhost:8088/api/faculty
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("facultys", facultyService.Get());
        return "faculty/index";
    }

    // GET
    @GetMapping(value = { "form", "form/{id}" })
    public String form(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            model.addAttribute("faculty", facultyService.Get(id));
            
        } else {
            model.addAttribute("faculty", new Faculty());

        }
        return "faculty/form";
    }

    // POST

    @PostMapping("save")
    public String submit(Faculty faculty) {
        Boolean result = facultyService.Save(faculty);
        if (result) {
            return "redirect:/faculty";
        } else {
            return "faculty/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        facultyService.Delete(id);
        return "redirect:/faculty";
    }
}
