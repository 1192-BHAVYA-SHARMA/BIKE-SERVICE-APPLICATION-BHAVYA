package com.example.BikeApplication.Controller;

import com.example.BikeApplication.Domain.User;
import com.example.BikeApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "*") //angular link
@RestController
@RequestMapping("/user") //used to map to angular
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        User newUser = userService.registerUser(user);
        System.out.println(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody Map<String, String> credentials) {
        System.out.println(credentials);
        //User user = userService.loginUser(credentials.get("userName"), credentials.get("password"));
        User user = userService.loginUser(credentials.get("email"), credentials.get("password"));
        System.out.println(user);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User updatedUserDetails) {
        User updatedUser = userService.updateUser(userId, updatedUserDetails);
        return updatedUser;
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return user;
    }


}
