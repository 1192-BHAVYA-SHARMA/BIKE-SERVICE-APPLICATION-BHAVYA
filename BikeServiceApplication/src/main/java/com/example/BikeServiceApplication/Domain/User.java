package com.example.BikeServiceApplication.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;
//Authentication--user
@Document(collection = "Users") //set name of collection in db
public class User {
    @Id
    private String User_id;
    private String User_name;

    @NotBlank
    @Size(max = 10)
    private String phone_no;//of 10digits -mobile no
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;//atleast 8 characters
    private PaymentMode payment_mode;
    private String address;

    @DBRef
    private Set<Role> roles = new HashSet<>();
    //constructor
    public User(String user_name ,String email,String password,String phone_no ,String address,String payment_mode)
    {
        this.User_name =user_name;
        this.email=email;
        this.password=password;
        this.phone_no=phone_no;
        this.address=address;
//        this.payment_mode=payment_mode;
        this.payment_mode = PaymentMode.valueOf(payment_mode.toUpperCase());
    }

    //setters and Getters
    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String user_id) {
        User_id = user_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PaymentMode getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(PaymentMode payment_mode) {
        this.payment_mode = payment_mode;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }
}
