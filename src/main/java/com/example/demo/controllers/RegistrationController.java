package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Registration;
import com.example.demo.services.StudentService;
import com.example.demo.services.ScheduleService;
import com.example.demo.services.RegistrationService;

@Controller
@RequestMapping("registration") // http://localhost:8088/api/registration
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("registrations", registrationService.Get());
        return "registration/index";
    }

    // GET
    @GetMapping(value = { "form", "form/{id}" })
    public String form(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            model.addAttribute("students", studentService.Get());
            model.addAttribute("schedules", scheduleService.Get());
            model.addAttribute("registration", registrationService.Get(id));
            
        } else {
            model.addAttribute("students", studentService.Get());
            model.addAttribute("schedules", scheduleService.Get());
            model.addAttribute("registration", new Registration());
            

        }
        return "registration/form";
    }

    // POST

    @PostMapping("save")
    public String save(Registration registration) {
        Boolean result = registrationService.Save(registration);
        if (result) {
            return "redirect:/registration";
        } else {
            return "registration/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        registrationService.Delete(id);
        return "redirect:/registration";
    }
}
