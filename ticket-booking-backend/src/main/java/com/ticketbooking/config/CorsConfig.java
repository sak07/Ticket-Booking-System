package com.ticketbooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS Configuration
 * 
 * This configuration allows the frontend (Next.js) to make requests to the backend
 * CORS = Cross-Origin Resource Sharing
 */
@Configuration
public class CorsConfig {
    
    /**
     * Configure CORS settings
     * 
     * Allows:
     * - Requests from http://localhost:3000 (Next.js frontend)
     * - All HTTP methods (GET, POST, PUT, DELETE, etc.)
     * - All headers
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Apply to all /api/* endpoints
                        .allowedOrigins("http://localhost:3000") // Allow Next.js frontend
                        .allowedMethods("*") // Allow all HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow cookies if needed
            }
        };
    }
}
