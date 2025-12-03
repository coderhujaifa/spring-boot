package com.huzaifa.aichat.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="chat_messages")
public class ChatMessage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    private User user;

    @Column(columnDefinition="TEXT")
    private String userMessage;

    @Column(columnDefinition="TEXT")
    private String aiResponse;

    private Instant createdAt;

    public ChatMessage(){}

    public ChatMessage(User user, String userMessage, String aiResponse, Instant createdAt){
        this.user = user;
        this.userMessage = userMessage;
        this.aiResponse = aiResponse;
        this.createdAt = createdAt;
    }

    // getters & setters
    public Long getId(){ return id; }
    public User getUser(){ return user; }
    public void setUser(User u){ this.user = u; }

    public String getUserMessage(){ return userMessage; }
    public void setUserMessage(String m){ this.userMessage = m; }

    public String getAiResponse(){ return aiResponse; }
    public void setAiResponse(String r){ this.aiResponse = r; }

    public Instant getCreatedAt(){ return createdAt; }
    public void setCreatedAt(Instant t){ this.createdAt = t; }
}
