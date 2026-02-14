package com.example.studyrecord.controller;

import com.example.studyrecord.dto.request.WorkbookCreateRequest;
import com.example.studyrecord.service.WorkbookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WorkbookController {

    private final WorkbookService workbookService;

    public WorkbookController(WorkbookService workbookService) {
        this.workbookService = workbookService;
    }

    @GetMapping("/subjects/{subjectId}/workbooks/new")
    public String newWorkbook(@PathVariable Long subjectId, Model model) {
        model.addAttribute("workbookCreateRequest", new WorkbookCreateRequest());
        return "workbooks/new";
    }
    @PostMapping("/subjects/{subjectId}/workbooks")
    public String create(@PathVariable Long subjectId, @Valid @ModelAttribute("workbookCreateRequest") WorkbookCreateRequest request,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "workbooks/new";
        }
        try {
            workbookService.create(request.getTitle(), subjectId);
        }
        catch (IllegalArgumentException e) {
            bindingResult.rejectValue("title", "duplicate", e.getMessage());
            return "workbooks/new";
        }
        redirectAttributes.addFlashAttribute("message","参考書の登録が完了しました");
        return "redirect:/home";
    }
}
