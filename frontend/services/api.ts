import { Event, BookingRequest, BookingResponse } from '@/types';

/**
 * API Service - Handles all communication with the backend
 * 
 * Base URL points to the Spring Boot backend running on port 8080
 */

const API_BASE_URL = 'http://localhost:8080/api';

/**
 * Fetch all available events
 * 
 * @returns Promise with array of events
 * @throws Error if request fails
 */
export async function fetchEvents(): Promise<Event[]> {
  try {
    const response = await fetch(`${API_BASE_URL}/events`);
    
    if (!response.ok) {
      throw new Error('Failed to fetch events');
    }
    
    return await response.json();
  } catch (error) {
    console.error('Error fetching events:', error);
    throw error;
  }
}

/**
 * Fetch a specific event by ID
 * 
 * @param id Event ID
 * @returns Promise with event details
 * @throws Error if request fails
 */
export async function fetchEventById(id: number): Promise<Event> {
  try {
    const response = await fetch(`${API_BASE_URL}/events/${id}`);
    
    if (!response.ok) {
      throw new Error('Failed to fetch event');
    }
    
    return await response.json();
  } catch (error) {
    console.error('Error fetching event:', error);
    throw error;
  }
}

/**
 * Create a new booking
 * 
 * @param bookingData Booking request data
 * @returns Promise with booking confirmation
 * @throws Error if booking fails (e.g., insufficient seats)
 */
export async function createBooking(bookingData: BookingRequest): Promise<BookingResponse> {
  try {
    const response = await fetch(`${API_BASE_URL}/bookings`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(bookingData),
    });
    
    // If response is not ok, parse error message
    if (!response.ok) {
      const errorData = await response.json();
      throw new Error(errorData.message || 'Failed to create booking');
    }
    
    return await response.json();
  } catch (error) {
    console.error('Error creating booking:', error);
    throw error;
  }
}
