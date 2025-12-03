package com.huzaifa.aichat.repository;

import java.util.List;
import com.huzaifa.aichat.entity.ChatMessage;

public interface ChatRepository {
    List<ChatMessage> searchMessages(Long userId, String keyword);
}
