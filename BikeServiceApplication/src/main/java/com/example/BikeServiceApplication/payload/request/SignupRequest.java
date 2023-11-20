package com.example.BikeServiceApplication.payload.request;

import javax.validation.constraints.*;
import java.util.Set;

public class SignupRequest {
    @NotBlank(message = "User Name is Required")
    @Size(min = 3, max = 20, message = "User Name must be between 3 to 20 characters")
    private String username;

    @NotBlank(message = "Email is Required")
    @Email(message = "Invalid email format")
    @Size(max = 50, message = "Email must be less than or equal to 50 characters")
    private String email;

    @NotBlank(message = "Phone Number is Required")
    @Size(min = 10, max = 10, message = "Phone Number must be exactly 10 digits")
    private String phoneNo;

    @NotBlank(message = "Password is Required")
    @Size(min = 8, max = 40, message = "Password must be between 8 to 40 characters")
    private String password;

    @NotBlank(message = "Payment Mode is Required")
    private String paymentMode;

    @NotBlank(message = "Address is Required")
    private String address;

    private Set<String> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return this.roles;
    }

    public void setRole(Set<String> roles) {
        this.roles = roles;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}