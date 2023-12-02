package com.example.BikeApplication.Repository;

import com.example.BikeApplication.Domain.ServiceProvider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceProviderRepo extends MongoRepository<ServiceProvider, String> {

    List<ServiceProvider> findByServiceCategories_Category(String category);

    ServiceProvider findServiceProviderById(String id);

}
