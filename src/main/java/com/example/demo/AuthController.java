package com.example.demo;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AuthController {

    Map<String, String> users = new HashMap<>();

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> data) {
        users.put(data.get("username"), data.get("password"));
        return "Registration Successful";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> data) {

        String username = data.get("username");
        String password = data.get("password");

        if (users.containsKey(username) &&
            users.get(username).equals(password)) {

            return jwtUtil.generateToken(username);
        }

        return "Invalid Username or Password";
    }
}
