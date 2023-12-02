package com.example.BikeApplication.Repository;

import com.example.BikeApplication.Domain.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {

    List<Booking>findByIdAndDateAndSlot(String id, String date, String slot);
    List<Booking> findByUserId(String userId);
}
