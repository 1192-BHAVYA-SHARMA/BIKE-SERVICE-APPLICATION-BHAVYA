package com.example.BikeApplication.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private int tiers;
    private int seats;
    private int brakes;// number of breakes
    private int oil; //oil in ml/l
    private int paint;
    private int lights;
    private int engine; //number of engins
}
