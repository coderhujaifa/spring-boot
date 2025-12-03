package com.huzaifa.aichat.service;

import org.springframework.stereotype.Service;
import com.huzaifa.aichat.entity.ChatMessage;
import com.huzaifa.aichat.entity.User;
import com.huzaifa.aichat.repository.ChatMessageRepository;
import com.huzaifa.aichat.repository.ChatRepository;
import com.huzaifa.aichat.repository.UserRepository;

import java.time.Instant;
import java.util.List;

@Service
public class ChatService {

    private final OpenAIService openAI;
    private final ChatMessageRepository chatRepo;
    private final ChatRepository chatCustomRepo;
    private final UserRepository userRepo;

    public ChatService(OpenAIService openAI,
                       ChatMessageRepository chatRepo,
                       ChatRepository chatCustomRepo,
                       UserRepository userRepo){

        this.openAI = openAI;
        this.chatRepo = chatRepo;
        this.chatCustomRepo = chatCustomRepo;
        this.userRepo = userRepo;
    }

    public ChatMessage sendMessage(String username, String message){
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String aiReply = openAI.getChatCompletion(message);

        ChatMessage cm = new ChatMessage(user, message, aiReply, Instant.now());
        return chatRepo.save(cm);
    }

    public List<ChatMessage> history(String username){
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return chatRepo.findByUserOrderByCreatedAtDesc(user);
    }

    public List<ChatMessage> search(String username, String keyword){
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return chatCustomRepo.searchMessages(user.getId(), keyword);
    }
}
