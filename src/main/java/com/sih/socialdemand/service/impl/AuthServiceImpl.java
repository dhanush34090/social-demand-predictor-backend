package com.sih.socialdemand.service.impl;

import com.sih.socialdemand.dto.AuthResponse;
import com.sih.socialdemand.dto.LoginRequest;
import com.sih.socialdemand.dto.SignupRequest;
import com.sih.socialdemand.entity.User;
import com.sih.socialdemand.repository.UserRepository;
import com.sih.socialdemand.service.AuthService;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AuthResponse signup(SignupRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        if (request.getRole() == null || request.getRole().isBlank()) {
            user.setRole("USER");
        } else {
            user.setRole(request.getRole().toUpperCase());
        }

        User savedUser = userRepository.save(user);

        return new AuthResponse(
                "Registration successful",
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole()
        );
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return new AuthResponse(
                "Login successful",
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}