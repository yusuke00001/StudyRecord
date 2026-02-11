package com.example.studyrecord.controller;

import com.example.studyrecord.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final SubjectService subjectService;

    public HomeController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @GetMapping("/home")
    public String home(Model model) {
        Long userId = 1L;
        model.addAttribute("subjects", subjectService.index(userId));
        return "home";
    }
}
