package com.example.BikeApplication.Domain;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//to get desired feild in history
public class BookingRequest {
    private String name;//provider name
    private String service; //service name
    private double price;
    private String date;
    private String slot;
}
