package com.example.BikeServiceApplication.Repository;

import com.example.BikeServiceApplication.Domain.Erole;
import com.example.BikeServiceApplication.Domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(Erole name);
}
