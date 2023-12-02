package com.example.BikeApplication.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Users") //set name of collection in db
public class User {
    @Id
    private String userId;
    private String userName;
    private String phone;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    private PaymentMode paymentMode;
    private String address;
    @NotBlank
    private String role;
}
