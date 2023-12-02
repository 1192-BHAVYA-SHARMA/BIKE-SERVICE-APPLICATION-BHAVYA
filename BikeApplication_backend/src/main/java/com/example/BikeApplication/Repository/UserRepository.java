package com.example.BikeApplication.Repository;

import com.example.BikeApplication.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String userName);
    User findByEmail(String email);
    User findByPhone(String phone);

    List<User> findAll();

    User findByUserId(String userId);
}
