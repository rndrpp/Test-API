package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;

@Controller
@RequestMapping("student") // http://localhost:8088/api/student
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("students", studentService.Get());
        return "student/index";
    }

    // GET
    @GetMapping(value = { "form", "form/{id}" })
    public String form(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            model.addAttribute("student", studentService.Get(id));
            
        } else {
            model.addAttribute("student", new Student());

        }
        return "student/form";
    }

    // POST

    @PostMapping("save")
    public String submit(Student student) {
        Boolean result = studentService.Save(student);
        if (result) {
            return "redirect:/student";
        } else {
            return "student/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        studentService.Delete(id);
        return "redirect:/student";
    }
}
