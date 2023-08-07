package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Group;
import com.example.demo.services.GroupService;

@Controller
@RequestMapping("group") // http://localhost:8088/api/group
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("groups", groupService.Get());
        return "group/index";
    }

    // GET
    @GetMapping(value = { "form", "form/{id}" })
    public String form(Model model, @PathVariable(required = false) Integer id) {
        if (id != null) {
            model.addAttribute("group", groupService.Get(id));
            
        } else {
            model.addAttribute("group", new Group());

        }
        return "group/form";
    }

    // POST

    @PostMapping("save")
    public String submit(Group group) {
        Boolean result = groupService.Save(group);
        if (result) {
            return "redirect:/group";
        } else {
            return "group/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        groupService.Delete(id);
        return "redirect:/group";
    }
}
