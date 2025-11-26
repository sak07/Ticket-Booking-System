package com.ticketbooking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Booking Entity - Represents a ticket booking made by a customer
 * 
 * This class maps to the 'bookings' table in the database
 */
@Entity
@Table(name = "bookings")
public class Booking {
    
    // ===================================
    // FIELDS
    // ===================================
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Link to the event being booked (Many bookings can belong to one event)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    
    @Column(nullable = false)
    private String customerName;
    
    @Column(nullable = false)
    private String customerEmail;
    
    // Number of seats booked in this booking
    @Column(nullable = false)
    private Integer numberOfSeats;
    
    // When this booking was created
    @Column(nullable = false)
    private LocalDateTime bookingDate;
    
    // ===================================
    // CONSTRUCTORS
    // ===================================
    
    /**
     * Default constructor (required by JPA)
     */
    public Booking() {
    }
    
    /**
     * Constructor with all fields
     */
    public Booking(Event event, String customerName, String customerEmail, 
                   Integer numberOfSeats, LocalDateTime bookingDate) {
        this.event = event;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.numberOfSeats = numberOfSeats;
        this.bookingDate = bookingDate;
    }
    
    // ===================================
    // GETTERS AND SETTERS
    // ===================================
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Event getEvent() {
        return event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
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
}
