package com.example.BikeApplication.Service;

import com.example.BikeApplication.Domain.ServiceProvider;
import com.example.BikeApplication.Repository.ServiceProviderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceProviderService {

    private final ServiceProviderRepo serviceProviderRepository;

    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepository.findAll();
    }

    public ServiceProvider findServiceProviderById(String id) {
        Optional<ServiceProvider> serviceProvider = serviceProviderRepository.findById(id);
        return serviceProvider.isPresent() ? serviceProvider.get() : null;
    }
    public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    public ServiceProvider updateServiceProvider(String id, ServiceProvider serviceProvider) {
        if (serviceProviderRepository.existsById(id)) {
            serviceProvider.setId(id);
            return serviceProviderRepository.save(serviceProvider);
        } else {
            return null;
        }
    }

    public void deleteServiceProviderById(String id) {
        serviceProviderRepository.deleteById(id);
    }


    public List<ServiceProvider>  getAllServiceProvidersByCategory(String category) {
        return serviceProviderRepository.findByServiceCategories_Category(category);
    }
}
