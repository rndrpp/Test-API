package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseService;

@Controller
@RequestMapping("course") // http://localhost:8088/api/course
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("courses", courseService.Get());
        return "course/index";
    }

    // GET
    @GetMapping(value = { "form", "form/{id}" })
    public String form(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            model.addAttribute("course", courseService.Get(id));
            
        } else {
            model.addAttribute("course", new Course());

        }
        return "course/form";
    }

    // POST

    @PostMapping("save")
    public String submit(Course course) {
        Boolean result = courseService.Save(course);
        if (result) {
            return "redirect:/course";
        } else {
            return "course/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        courseService.Delete(id);
        return "redirect:/course";
    }
}
