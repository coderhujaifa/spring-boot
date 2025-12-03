package com.huzaifa.aichat.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.List;

@Service
public class OpenAIService {

    private final WebClient webClient;

    public OpenAIService(@Value("${openai.api.key:}") String apiKey){

        String key = (apiKey == null || apiKey.isEmpty())
                ? System.getenv("OPENAI_API_KEY")
                : apiKey;

        if(key == null || key.isEmpty())
            throw new IllegalStateException("OpenAI API key not set!");

        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com")
                .defaultHeader("Authorization", "Bearer " + key)
                .build();
    }

    public String getChatCompletion(String userMessage){

        Map<String,Object> body = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(Map.of("role", "user", "content", userMessage)),
                "max_tokens", 500
        );

        Map response = webClient.post()
                .uri("/v1/chat/completions")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if(response == null) return "AI did not respond";

        List choices = (List) response.get("choices");
        if(choices == null || choices.isEmpty()) return "No choices returned";

        Map first = (Map) choices.get(0);
        Map msg = (Map) first.get("message");

        return msg.get("content").toString().trim();
    }
}
