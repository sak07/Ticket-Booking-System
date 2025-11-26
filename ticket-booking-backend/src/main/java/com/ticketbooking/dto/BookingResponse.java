package com.ticketbooking.dto;

import java.time.LocalDateTime;

/**
 * Booking Response DTO
 * 
 * This class represents the data sent back to the frontend after a successful booking
 */
public class BookingResponse {
    
    // ===================================
    // FIELDS
    // ===================================
    
    private Long bookingId;
    private String eventName;
    private String customerName;
    private String customerEmail;
    private Integer numberOfSeats;
    private LocalDateTime bookingDate;
    private String message;
    
    // ===================================
    // CONSTRUCTORS
    // ===================================
    
    public BookingResponse() {
    }
    
    public BookingResponse(Long bookingId, String eventName, String customerName, 
                          String customerEmail, Integer numberOfSeats, 
                          LocalDateTime bookingDate, String message) {
        this.bookingId = bookingId;
        this.eventName = eventName;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.numberOfSeats = numberOfSeats;
        this.bookingDate = bookingDate;
        this.message = message;
    }
    
    // ===================================
    // GETTERS AND SETTERS
    // ===================================
    
    public Long getBookingId() {
        return bookingId;
    }
    
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    
    public String getEventName() {
        return eventName;
    }
    
    public void setEventName(String eventName) {
        this.eventName = eventName;
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
    
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }
    
    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
