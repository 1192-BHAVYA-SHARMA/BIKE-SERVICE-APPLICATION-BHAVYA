package com.example.BikeApplication.Service;

import com.example.BikeApplication.Domain.Booking;
import com.example.BikeApplication.Domain.BookingRequest;
import com.example.BikeApplication.Domain.ServiceCategory;
import com.example.BikeApplication.Domain.ServiceProvider;
import com.example.BikeApplication.Repository.BookingRepository;
import com.example.BikeApplication.Repository.ServiceProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ServiceProviderRepo serviceProviderRepo;

    public Booking bookAppointment(Booking bookingRequest) throws Exception {
        // Check if provider is available on given date and slot
        ServiceProvider provider = serviceProviderRepo.findServiceProviderById(bookingRequest.getId());
        if (provider == null) {
            throw new Exception("Provider not found");
        }
        List<Booking> bookings = bookingRepository.findByIdAndDateAndSlot(bookingRequest.getId(),
                bookingRequest.getDate(),bookingRequest.getSlot());
        if (!bookings.isEmpty()) {
            throw new Exception("Slot already booked, please choose another slot.");
        }

        // Create a new booking
        Booking booking = new Booking();
        booking.setUserId(bookingRequest.getUserId());
        booking.setId(bookingRequest.getId());
        booking.setDate(bookingRequest.getDate());
        booking.setSlot(bookingRequest.getSlot());

        return bookingRepository.save(booking);
    }

}
