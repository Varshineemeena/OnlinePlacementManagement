package com.placement.management.rest.controller;

import com.placement.management.rest.model.login.in.AuthRequest;
import com.placement.management.rest.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/register")
    String registerUser(@RequestBody AuthRequest authRequest) {
        return "Registered Successfully";
    }
}
