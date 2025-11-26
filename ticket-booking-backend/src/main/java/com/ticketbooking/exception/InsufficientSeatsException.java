package com.ticketbooking.exception;

/**
 * Custom Exception for Insufficient Seats
 * 
 * This exception is thrown when a user tries to book more seats than available
 */
public class InsufficientSeatsException extends RuntimeException {
    
    /**
     * Constructor with custom error message
     */
    public InsufficientSeatsException(String message) {
        super(message);
    }
}
