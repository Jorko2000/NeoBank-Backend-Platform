package com.neobank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.neobank.repository.UserRepository;
import com.neobank.model.User;
import com.neobank.security.JwtUtil;
import com.neobank.dto.AuthRequest;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repo;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        repo.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest req) {
        User user = repo.findByUsername(req.getUsername());

        if (user == null || !user.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
