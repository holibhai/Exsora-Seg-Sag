package com.crudoperation.jw.dto;

import org.aspectj.bridge.IMessage;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message="password is required")
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
