package com.example.demo.controllers;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.handler.Response;
import com.example.demo.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api") // http://localhost:8088/api
public class UserRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;

    @PostMapping("user/login") // http://localhost:8088/api/user/login
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.isAuthenticated()) {
            return Response.generate(HttpStatus.OK, "account has been login");
        }
        return Response.generate(HttpStatus.OK, "data failed to login");
    }

    @PostMapping("user/register") // http://localhost:8088/api/user//register
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest) {
        Boolean result = accountService.register(registerRequest);
        if (result) {
            return Response.generate(HttpStatus.OK, "data has been saved");
        }
        return Response.generate(HttpStatus.OK, "data failed to save");
    }

    @PostMapping("user/forgot") // http://localhost:8088//api/user/forgot
    public String forgotPassword() {
        return "";
    }

    @PostMapping("user/changePassword") // http://localhost:8088//api/user/changePassword
    public String changePassword() {
        return "";
    }
}