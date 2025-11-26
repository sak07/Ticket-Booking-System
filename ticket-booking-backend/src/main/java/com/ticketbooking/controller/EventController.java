package com.ticketbooking.controller;

import com.ticketbooking.model.Event;
import com.ticketbooking.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Event Controller - REST API endpoints for events
 * 
 * This controller handles HTTP requests related to events
 * Base URL: /api/events
 */
@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from Next.js frontend
public class EventController {
    
    // ===================================
    // DEPENDENCIES
    // ===================================
    
    @Autowired
    private EventService eventService;
    
    // ===================================
    // API ENDPOINTS
    // ===================================
    
    /**
     * GET /api/events
     * Get all available events
     * 
     * @return List of all events
     */
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }
    
    /**
     * GET /api/events/{id}
     * Get a specific event by ID
     * 
     * @param id Event ID from URL path
     * @return Event details
     */
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }
}
