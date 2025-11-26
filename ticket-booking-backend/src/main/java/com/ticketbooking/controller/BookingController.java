package com.ticketbooking.controller;

import com.ticketbooking.dto.BookingRequest;
import com.ticketbooking.dto.BookingResponse;
import com.ticketbooking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Booking Controller - REST API endpoints for bookings
 * 
 * This controller handles HTTP requests related to bookings
 * Base URL: /api/bookings
 */
@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from Next.js frontend
public class BookingController {
    
    // ===================================
    // DEPENDENCIES
    // ===================================
    
    @Autowired
    private BookingService bookingService;
    
    // ===================================
    // API ENDPOINTS
    // ===================================
    
    /**
     * POST /api/bookings
     * Create a new booking
     * 
     * @Valid annotation ensures the request body is validated
     * @param request Booking request from frontend
     * @return Booking confirmation response
     */
    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@Valid @RequestBody BookingRequest request) {
        BookingResponse response = bookingService.createBooking(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
