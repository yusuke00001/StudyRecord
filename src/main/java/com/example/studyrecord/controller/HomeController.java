package com.example.studyrecord.controller;

import com.example.studyrecord.entity.Subject;
import com.example.studyrecord.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final SubjectService subjectService;

    public HomeController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @GetMapping("/home")
    public String home(Model model) {
        Long userId = 1L;
        List<Subject> subjects = subjectService.index(userId);
        model.addAttribute("subjects",subjects);

        return "home";
    }
}
