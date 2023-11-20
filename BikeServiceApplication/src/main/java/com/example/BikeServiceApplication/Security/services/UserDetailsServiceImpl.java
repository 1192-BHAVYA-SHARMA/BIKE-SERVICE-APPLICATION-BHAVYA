package com.example.BikeServiceApplication.Security.services;

import com.example.BikeServiceApplication.Domain.User;
import com.example.BikeServiceApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UserRepository userRepository;
    //check if provided email or phone no is registered or not
    // if yes then get user object via build method of userdetailsImp.class
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userByEmail = userRepository.findByEmail(username);
        if (userByEmail.isPresent()) {
            return UserDetailsImpl.build(userByEmail);
        }
        Optional<User> userByPhoneNo = userRepository.findByPhoneNo(username);
        if (userByPhoneNo.isPresent()) {
            return UserDetailsImpl.build(userByPhoneNo);
        }
        throw new UsernameNotFoundException("User not found with email/phone no: " + username);
    }

}


