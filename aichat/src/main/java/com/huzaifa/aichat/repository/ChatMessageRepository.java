package com.huzaifa.aichat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huzaifa.aichat.entity.ChatMessage;
import com.huzaifa.aichat.entity.User;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findByUserOrderByCreatedAtDesc(User user);

}
