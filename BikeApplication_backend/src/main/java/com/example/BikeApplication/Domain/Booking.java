package com.example.BikeApplication.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Booked") //set name of collection in dbr
public class Booking {
    @Id
    private String b_id;
    private String userId;
    private String id;//providerid
    private String date;
    private String slot;
}
