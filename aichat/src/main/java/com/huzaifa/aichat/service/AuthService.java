package com.huzaifa.aichat.service;

import org.springframework.stereotype.Service;
import com.huzaifa.aichat.entity.User;
import com.huzaifa.aichat.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Set;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public AuthService(UserRepository userRepo, PasswordEncoder encoder){
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public User register(String username, String rawPassword){
        if(userRepo.existsByUsername(username))
            throw new RuntimeException("Username already taken!");

        User u = new User(username, encoder.encode(rawPassword), Set.of("USER"));
        return userRepo.save(u);
    }
}
