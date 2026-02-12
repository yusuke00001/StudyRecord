package com.example.studyrecord.controller;

import com.example.studyrecord.dto.request.SubjectCreateRequest;
import com.example.studyrecord.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects/new")
    public String newSubject(Model model) {
        model.addAttribute("subjectCreateRequest", new SubjectCreateRequest());
        return "subjects/new";
    }

    @PostMapping("/subjects")
    public String create(@Valid @ModelAttribute("subjectCreateRequest") SubjectCreateRequest request,
                       BindingResult bindingResult) {
        Long userId = 1L;
        if (bindingResult.hasErrors()) {
            return "subjects/new";
        }
        try {
            subjectService.create(request.getTitle(), userId);
        }
        catch (IllegalArgumentException e) {
            bindingResult.rejectValue("title","duplicate",e.getMessage());
            return "subjects/new";
        }
        return "redirect:/home";
    }
    @PostMapping("/subjects/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        subjectService.delete(id);
        return "redirect:/home";
    }
}
