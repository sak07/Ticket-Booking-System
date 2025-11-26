package com.ticketbooking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Booking Request DTO (Data Transfer Object)
 * 
 * This class represents the data sent from the frontend when creating a booking
 * It includes validation rules to ensure data quality
 */
public class BookingRequest {
    
    // ===================================
    // FIELDS WITH VALIDATION
    // ===================================
    
    // Event ID must be provided
    @NotNull(message = "Event ID is required")
    private Long eventId;
    
    // Customer name cannot be blank
    @NotBlank(message = "Customer name is required")
    private String customerName;
    
    // Customer email must be valid format
    @NotBlank(message = "Customer email is required")
    @Email(message = "Please provide a valid email address")
    private String customerEmail;
    
    // Number of seats must be at least 1
    @NotNull(message = "Number of seats is required")
    @Min(value = 1, message = "Must book at least 1 seat")
    private Integer numberOfSeats;
    
    // ===================================
    // CONSTRUCTORS
    // ===================================
    
    public BookingRequest() {
    }
    
    public BookingRequest(Long eventId, String customerName, String customerEmail, Integer numberOfSeats) {
        this.eventId = eventId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.numberOfSeats = numberOfSeats;
    }
    
    // ===================================
    // GETTERS AND SETTERS
    // ===================================
    
    public Long getEventId() {
        return eventId;
    }
    
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getCustomerEmail() {
        return customerEmail;
    }
    
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    
    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }
    
    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
