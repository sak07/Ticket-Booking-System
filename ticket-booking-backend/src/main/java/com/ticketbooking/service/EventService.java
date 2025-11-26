package com.ticketbooking.service;

import com.ticketbooking.model.Event;
import com.ticketbooking.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Event Service - Business logic for event operations
 * 
 * This service handles all event-related operations like
 * fetching all events and getting event details
 */
@Service
public class EventService {
    
    // ===================================
    // DEPENDENCIES
    // ===================================
    
    @Autowired
    private EventRepository eventRepository;
    
    // ===================================
    // PUBLIC METHODS
    // ===================================
    
    /**
     * Get all available events
     * 
     * @return List of all events in the database
     */
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    
    /**
     * Get a specific event by ID
     * 
     * @param id Event ID
     * @return Event object
     * @throws RuntimeException if event not found
     */
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + id));
    }
}
