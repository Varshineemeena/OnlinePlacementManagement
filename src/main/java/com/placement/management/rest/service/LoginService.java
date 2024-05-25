package com.placement.management.rest.service;

import com.placement.management.entity.Login;
import com.placement.management.rest.model.login.out.AuthResponse;
import com.placement.management.rest.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;

    public List<Login> getUsers() {
        return loginRepository.findAll();
    }

    public Login registerUser(Login login) {
        return loginRepository.save(login);
    }

    public AuthResponse loginUser(Login login, String role) {
        Login byId = loginRepository.findById(login.getUsername()).orElse(null);
        AuthResponse authResponse = new AuthResponse();
        if (byId != null) {
            authResponse.setStatus(byId.getRole().equalsIgnoreCase(role) && byId.getPassword().equalsIgnoreCase(login.getPassword()) ? "Valid" : "User Not Authorized");
        } else {
            authResponse.setStatus("InValid");
            authResponse.setErrorCode("404");
            authResponse.setErrorStatus("User not found");
        }

        return authResponse;
    }
}
