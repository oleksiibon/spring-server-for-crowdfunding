package com.example.crowdfunding.Security.controller;

public class JwtAuthenticationResponse {

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
