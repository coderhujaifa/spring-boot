package com.huzaifa.aichat.controller;

import org.springframework.web.bind.annotation.*;
import com.huzaifa.aichat.entity.ChatMessage;
import com.huzaifa.aichat.service.ChatService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @PostMapping("/send")
    public ChatMessage send(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody Map<String,String> body){
        return chatService.sendMessage(userDetails.getUsername(), body.get("message"));
    }

    @GetMapping("/history")
    public List<ChatMessage> history(@AuthenticationPrincipal UserDetails userDetails){
        return chatService.history(userDetails.getUsername());
    }

    @GetMapping("/search")
    public List<ChatMessage> search(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam String q){
        return chatService.search(userDetails.getUsername(), q);
    }
}
