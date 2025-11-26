/**
 * TypeScript Type Definitions
 * 
 * These types define the structure of data used throughout the application
 */

/**
 * Event - Represents an event that can be booked
 */
export interface Event {
  id: number;
  name: string;
  description: string;
  eventDate: string; // ISO date string
  venue: string;
  totalSeats: number;
  availableSeats: number;
}

/**
 * BookingRequest - Data sent when creating a booking
 */
export interface BookingRequest {
  eventId: number;
  customerName: string;
  customerEmail: string;
  numberOfSeats: number;
}

/**
 * BookingResponse - Response received after successful booking
 */
export interface BookingResponse {
  bookingId: number;
  eventName: string;
  customerName: string;
  customerEmail: string;
  numberOfSeats: number;
  bookingDate: string;
  message: string;
}

/**
 * ErrorResponse - Structure of error responses from API
 */
export interface ErrorResponse {
  timestamp: string;
  status: number;
  message?: string;
  errors?: Record<string, string>;
}
