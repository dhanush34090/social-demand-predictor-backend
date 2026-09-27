package com.sih.socialdemand.controller;

import com.sih.socialdemand.dto.AuthResponse;
import com.sih.socialdemand.dto.LoginRequest;
import com.sih.socialdemand.dto.SignupRequest;
import com.sih.socialdemand.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(
            @RequestBody SignupRequest request) {

        return ResponseEntity.ok(
                authService.signup(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }
}