package com.example.BikeApplication.Service;

import com.example.BikeApplication.Domain.User;
import com.example.BikeApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User registerUser(User user) {
        // Check if username, email, or phone number is already registered
        System.out.println(user);
        System.out.println(userRepository.findByUserName(user.getUserName()));
        if(user.getEmail() != null && userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        if(user.getPhone() != null && userRepository.findByPhone(user.getPhone()) != null) {
            throw new RuntimeException("Phone number already exists");
        }
       // Encrypt password before setting it
           user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        //WITHOUT BYCRYPT : user.setPassword(user.getPassword());
        return userRepository.save(user);// Save user to database
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        // Check if user exists and password is correct
        if(user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(String userId, User updatedUserDetails) {
        User userToUpdate = userRepository.findByUserId(userId);
        System.out.println(userToUpdate);
        userToUpdate.setUserName(updatedUserDetails.getUserName());
        userToUpdate.setPhone(updatedUserDetails.getPhone());
        userToUpdate.setEmail(updatedUserDetails.getEmail());
        userToUpdate.setPassword(updatedUserDetails.getPassword());
        userToUpdate.setPaymentMode(updatedUserDetails.getPaymentMode());
        userToUpdate.setAddress(updatedUserDetails.getAddress());
        userToUpdate.setRole(updatedUserDetails.getRole());
        User updatedUser = userRepository.save(userToUpdate);
        return updatedUser;
    }

    public User getUserById(String userId) {
        User user = userRepository.findByUserId(userId);
        return user;
    }
}
