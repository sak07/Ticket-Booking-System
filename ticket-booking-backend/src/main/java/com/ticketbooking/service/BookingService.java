package com.ticketbooking.service;

import com.ticketbooking.dto.BookingRequest;
import com.ticketbooking.dto.BookingResponse;
import com.ticketbooking.exception.InsufficientSeatsException;
import com.ticketbooking.model.Booking;
import com.ticketbooking.model.Event;
import com.ticketbooking.repository.BookingRepository;
import com.ticketbooking.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Booking Service - Business logic for booking operations
 * 
 * This service handles booking creation and seat validation
 * Uses @Transactional to ensure data consistency
 */
@Service
public class BookingService {
    
    // ===================================
    // DEPENDENCIES
    // ===================================
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private EventRepository eventRepository;
    
    // ===================================
    // PUBLIC METHODS
    // ===================================
    
    /**
     * Create a new booking
     * 
     * This method:
     * 1. Finds the event
     * 2. Checks if enough seats are available
     * 3. Creates the booking
     * 4. Updates available seats
     * 
     * @Transactional ensures all steps complete successfully or none do
     * synchronized prevents multiple users from booking the same seats simultaneously
     * 
     * @param request Booking request with customer details
     * @return BookingResponse with confirmation details
     * @throws RuntimeException if event not found
     * @throws InsufficientSeatsException if not enough seats available
     */
    @Transactional
    public synchronized BookingResponse createBooking(BookingRequest request) {
        
        // Step 1: Find the event
        Event event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + request.getEventId()));
        
        // Step 2: Check if enough seats are available
        if (event.getAvailableSeats() < request.getNumberOfSeats()) {
            throw new InsufficientSeatsException(
                "Not enough seats available. Requested: " + request.getNumberOfSeats() + 
                ", Available: " + event.getAvailableSeats()
            );
        }
        
        // Step 3: Create the booking
        Booking booking = new Booking();
        booking.setEvent(event);
        booking.setCustomerName(request.getCustomerName());
        booking.setCustomerEmail(request.getCustomerEmail());
        booking.setNumberOfSeats(request.getNumberOfSeats());
        booking.setBookingDate(LocalDateTime.now());
        
        // Save booking to database
        Booking savedBooking = bookingRepository.save(booking);
        
        // Step 4: Update available seats
        event.setAvailableSeats(event.getAvailableSeats() - request.getNumberOfSeats());
        eventRepository.save(event);
        
        // Step 5: Create and return response
        return new BookingResponse(
            savedBooking.getId(),
            event.getName(),
            savedBooking.getCustomerName(),
            savedBooking.getCustomerEmail(),
            savedBooking.getNumberOfSeats(),
            savedBooking.getBookingDate(),
            "Booking successful! Your booking ID is: " + savedBooking.getId()
        );
    }
}
