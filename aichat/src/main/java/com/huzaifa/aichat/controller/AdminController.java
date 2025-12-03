package com.huzaifa.aichat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huzaifa.aichat.repository.ChatMessageRepository;
import com.huzaifa.aichat.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepo;
    private final ChatMessageRepository chatRepo;

    public AdminController(UserRepository userRepo, ChatMessageRepository chatRepo){
        this.userRepo = userRepo;
        this.chatRepo = chatRepo;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("chats", chatRepo.findAll());
        return "admin/dashboard";
    }
}
