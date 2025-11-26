package com.ticketbooking.repository;

import com.ticketbooking.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Event Repository - Handles database operations for Event entity
 * 
 * JpaRepository provides built-in methods like:
 * - findAll() - Get all events
 * - findById() - Get event by ID
 * - save() - Create or update event
 * - delete() - Delete event
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
    // Spring Data JPA automatically implements basic CRUD operations
    // No need to write SQL queries for common operations
    
}
