package com.ticketbooking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Event Entity - Represents an event that users can book tickets for
 * 
 * This class maps to the 'events' table in the database
 */
@Entity
@Table(name = "events")
public class Event {
    
    // ===================================
    // FIELDS
    // ===================================
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(length = 1000)
    private String description;
    
    @Column(nullable = false)
    private LocalDateTime eventDate;
    
    @Column(nullable = false)
    private String venue;
    
    // Total number of seats available for this event
    @Column(nullable = false)
    private Integer totalSeats;
    
    // Number of seats currently available (decreases with each booking)
    @Column(nullable = false)
    private Integer availableSeats;
    
    // ===================================
    // CONSTRUCTORS
    // ===================================
    
    /**
     * Default constructor (required by JPA)
     */
    public Event() {
    }
    
    /**
     * Constructor with all fields
     */
    public Event(String name, String description, LocalDateTime eventDate, 
                 String venue, Integer totalSeats, Integer availableSeats) {
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
        this.venue = venue;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDateTime getEventDate() {
        return eventDate;
    }
    
    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
    
    public String getVenue() {
        return venue;
    }
    
    public void setVenue(String venue) {
        this.venue = venue;
    }
    
    public Integer getTotalSeats() {
        return totalSeats;
    }
    
    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }
    
    public Integer getAvailableSeats() {
        return availableSeats;
    }
    
    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}
