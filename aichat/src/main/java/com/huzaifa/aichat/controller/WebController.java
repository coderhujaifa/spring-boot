package com.huzaifa.aichat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.huzaifa.aichat.repository.UserRepository;
import com.huzaifa.aichat.service.AuthService;

@Controller
public class WebController {

    private final AuthService authService;
    private final UserRepository userRepo;

    public WebController(AuthService authService, UserRepository userRepo){
        this.authService = authService;
        this.userRepo = userRepo;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           Model model){
        try {
            authService.register(username, password);
            return "redirect:/login?registered";
        } catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/chat")
    public String chatPage(){
        return "chat";
    }
}
