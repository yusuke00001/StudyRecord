package com.example.studyrecord.controller;

import com.example.studyrecord.dto.request.UserCreateRequest;
import com.example.studyrecord.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("userCreateRequest", new UserCreateRequest());
        return "users/new";
    }

    @PostMapping("/users")
    public String create(@Valid @ModelAttribute("userCreateRequest") UserCreateRequest request,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        try {
            userService.create(request.getName(), request.getEmail());
        }
        catch (IllegalArgumentException e) {
            bindingResult.rejectValue("email", "duplicate", e.getMessage());
            return "users/new";
        }
        redirectAttributes.addFlashAttribute("message", "ユーザー登録が完了しました");
        return "redirect:/home";
    }
}