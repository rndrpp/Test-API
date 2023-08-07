package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Program;
import com.example.demo.services.ProgramService;

@Controller
@RequestMapping("program") // http://localhost:8088/api/program
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("programs", programService.Get());
        return "program/index";
    }

    // GET
    @GetMapping(value = { "form", "form/{id}" })
    public String form(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            model.addAttribute("program", programService.Get(id));
            
        } else {
            model.addAttribute("program", new Program());

        }
        return "program/form";
    }

    // POST

    @PostMapping("save")
    public String submit(Program program) {
        Boolean result = programService.Save(program);
        if (result) {
            return "redirect:/program";
        } else {
            return "program/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        programService.Delete(id);
        return "redirect:/program";
    }
}
