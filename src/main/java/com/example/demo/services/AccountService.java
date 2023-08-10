package com.example.demo.services;

import com.example.demo.dto.RegisterRequest;

public interface AccountService {
    public boolean register(RegisterRequest registerRequest);
}
