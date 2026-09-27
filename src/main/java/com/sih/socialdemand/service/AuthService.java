package com.sih.socialdemand.service;

import com.sih.socialdemand.dto.AuthResponse;
import com.sih.socialdemand.dto.LoginRequest;
import com.sih.socialdemand.dto.SignupRequest;

public interface AuthService {

    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}