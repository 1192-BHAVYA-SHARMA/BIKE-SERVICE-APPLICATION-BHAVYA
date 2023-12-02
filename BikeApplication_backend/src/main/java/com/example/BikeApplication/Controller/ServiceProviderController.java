package com.example.BikeApplication.Controller;

import com.example.BikeApplication.Domain.ServiceProvider;
import com.example.BikeApplication.Domain.User;
import com.example.BikeApplication.Service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

 //angular link
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/service_providers")
public class ServiceProviderController {
    @Autowired
    private ServiceProviderService serviceProviderService;

    // Get all service providers
    @GetMapping("/allservicesproviders")
    public ResponseEntity<List<ServiceProvider>> getAllServiceProviders() {
        List<ServiceProvider> serviceProviders = serviceProviderService.getAllServiceProviders();
        HttpStatus status = !serviceProviders.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return ResponseEntity.status(status).body(serviceProviders);
    }

    // Get a single service provider by id

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProvider> getServiceProviderById(@PathVariable String id) {
        ServiceProvider serviceProvider = serviceProviderService.findServiceProviderById(id);
        HttpStatus status = serviceProvider != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(serviceProvider);
    }


    // Create a new service provider

    @PostMapping("/provider")
    public ResponseEntity<ServiceProvider> createServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        ServiceProvider addedServiceProvider = serviceProviderService.addServiceProvider(serviceProvider);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedServiceProvider);
    }


    // Update an existing service provider

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProvider> updateServiceProvider(@PathVariable String id, @RequestBody ServiceProvider serviceProvider) {
        System.out.println("came to backend");
        ServiceProvider updatedServiceProvider = serviceProviderService.updateServiceProvider(id, serviceProvider);
        if (updatedServiceProvider != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedServiceProvider);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete an existing service provider by id
    @DeleteMapping("/{id}")

    public ResponseEntity<User> deleteServiceProvider(@PathVariable String id) {
        serviceProviderService.deleteServiceProviderById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    //get providers according to category
    @GetMapping("/category/{category}")

    public ResponseEntity<List<ServiceProvider>> getAllServiceProvidersByCategory(@PathVariable String category) {
        List<ServiceProvider> serviceProviderList = serviceProviderService.getAllServiceProvidersByCategory(category);
        return ResponseEntity.ok(serviceProviderList);
    }




}
