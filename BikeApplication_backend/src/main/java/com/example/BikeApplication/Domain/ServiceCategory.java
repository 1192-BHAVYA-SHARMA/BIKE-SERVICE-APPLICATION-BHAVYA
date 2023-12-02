package com.example.BikeApplication.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCategory {
    private String service;
    private double price;
    private String category;
}
