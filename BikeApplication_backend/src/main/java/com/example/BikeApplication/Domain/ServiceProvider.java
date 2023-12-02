package com.example.BikeApplication.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "serviceProviders")
public class ServiceProvider {
    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String location;


    private double rating;

    @NotBlank

    private String expertise;

    @NotEmpty
    private List<ServiceCategory> serviceCategories;

    private double latitude ;
    private double longitude;

   private List<String> review;


    public ServiceProvider(String name, String location,
                           double rating, String expertise, List<ServiceCategory> serviceCategories
    , double latitude,double longitude , List<String> review) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.expertise = expertise;
        this.serviceCategories = serviceCategories;
        this.latitude=latitude;
        this.longitude=longitude;
        this.review= review;
    }

}
