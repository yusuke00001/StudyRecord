package com.example.studyrecord.controller;

import com.example.studyrecord.dto.request.StudyRecordCreateRequest;
import com.example.studyrecord.service.StudyRecordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudyRecordController {

    private final StudyRecordService studyRecordService;

    public StudyRecordController(StudyRecordService studyRecordService) {
        this.studyRecordService = studyRecordService;
    }

    @GetMapping("/subjects/{subjectId}/workbooks/{workbookId}/studyRecords/new")
    public String newStudyRecord(@PathVariable Long subjectId, @PathVariable Long workbookId, Model model) {
        model.addAttribute("subjectId", subjectId);
        model.addAttribute("workbookId", workbookId);
        model.addAttribute("studyRecordCreateRequest", new StudyRecordCreateRequest());
        return "studyRecords/new";
    }

    @PostMapping("/subjects/{subjectId}/workbooks/{workbookId}/studyRecords")
    public String create(@PathVariable Long subjectId, @PathVariable Long workbookId, @Valid @ModelAttribute("studyRecordCreateRequest") StudyRecordCreateRequest request,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("subjectId", subjectId);
            model.addAttribute("workbookId", workbookId);
            return "studyRecords/new";
        }
        try {
            studyRecordService.create(request.getStudyDate(), request.getQuestionNumber(), request.getLink(), request.getResult(), workbookId);
        }
        catch (IllegalArgumentException e) {
            model.addAttribute("message", "参考書が見つかりません");
            model.addAttribute("subjectId", subjectId);
            model.addAttribute("workbookId", workbookId);
            return "studyRecords/new";
        }
        return "redirect:/home";
    }
}
