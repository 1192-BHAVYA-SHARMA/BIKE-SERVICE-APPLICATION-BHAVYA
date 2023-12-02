package com.example.BikeApplication.Controller;

import com.example.BikeApplication.Domain.Booking;
import com.example.BikeApplication.Domain.BookingRequest;
import com.example.BikeApplication.Domain.ServiceProvider;
import com.example.BikeApplication.Service.BookingService;
import com.example.BikeApplication.Service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private ServiceProviderService serviceProviderService;

    @PostMapping()
    public ResponseEntity<Booking> bookAppointment(@RequestBody Booking bookingRequest) {

        try {
            Booking booking = bookingService.bookAppointment(bookingRequest);
            return ResponseEntity.ok(booking);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProvider> getServiceProviderById(@PathVariable String id) {
        ServiceProvider serviceProvider = serviceProviderService.findServiceProviderById(id);
        HttpStatus status = serviceProvider != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(serviceProvider);
    }


}
