package com.placement.management.rest.model.login.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String status;
    private String errorCode;
    private String errorStatus;
}
