package com.ticketbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Application Class
 * 
 * This is the entry point of the Spring Boot application
 * @SpringBootApplication enables auto-configuration and component scanning
 */
@SpringBootApplication
public class TicketBookingApplication {
    
    /**
     * Main method - starts the Spring Boot application
     */
    public static void main(String[] args) {
        SpringApplication.run(TicketBookingApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("Ticket Booking Backend is running!");
        System.out.println("API Base URL: http://localhost:8080/api");
        System.out.println("H2 Console: http://localhost:8080/h2-console");
        System.out.println("========================================\n");
    }
}
