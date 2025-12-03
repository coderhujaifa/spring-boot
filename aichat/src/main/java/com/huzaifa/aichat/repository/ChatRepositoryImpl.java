package com.huzaifa.aichat.repository;

import org.springframework.stereotype.Repository;
import com.huzaifa.aichat.entity.ChatMessage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ChatRepositoryImpl implements ChatRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ChatMessage> searchMessages(Long userId, String keyword) {

        String q = """
                SELECT c FROM ChatMessage c
                WHERE c.user.id = :uid
                AND (LOWER(c.userMessage) LIKE :kw OR LOWER(c.aiResponse) LIKE :kw)
                ORDER BY c.createdAt DESC
                """;

        return em.createQuery(q, ChatMessage.class)
                .setParameter("uid", userId)
                .setParameter("kw", "%" + keyword.toLowerCase() + "%")
                .getResultList();
    }
}
