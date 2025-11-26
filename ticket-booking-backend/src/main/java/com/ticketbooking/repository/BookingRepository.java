package com.ticketbooking.repository;

import com.ticketbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Booking Repository - Handles database operations for Booking entity
 * 
 * JpaRepository provides built-in methods for database operations
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    // Spring Data JPA automatically implements basic CRUD operations
    // Additional custom queries can be added here if needed
    
}
