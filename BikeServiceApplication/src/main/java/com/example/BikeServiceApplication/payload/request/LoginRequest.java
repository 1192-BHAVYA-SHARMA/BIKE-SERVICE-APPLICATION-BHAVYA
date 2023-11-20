package com.example.BikeServiceApplication.payload.request;

import javax.validation.constraints.*;
//login via phone no or email
public class LoginRequest {
    @NotBlank(message="Either Email or Phone Number is required")
    private String emailOrPhone;

    @NotBlank
    private String password;

    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone = emailOrPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}