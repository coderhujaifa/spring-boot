package com.huzaifa.aichat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huzaifa.aichat.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
