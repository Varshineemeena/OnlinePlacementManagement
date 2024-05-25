package com.placement.management.rest.controller;

import com.placement.management.entity.Login;
import com.placement.management.rest.model.login.out.AuthResponse;
import com.placement.management.rest.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/register")
    public Login registerUser(@RequestBody Login login) {
        return loginService.registerUser(login);
    }

    @GetMapping("/getUsers")
    public List<Login> getUsers() {
        return loginService.getUsers();
    }

    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody Login login, @RequestParam String role) {
        return loginService.loginUser(login, role);
    }
}
