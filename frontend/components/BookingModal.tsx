'use client';

import { Event, BookingRequest } from '@/types';
import { createBooking } from '@/services/api';
import { useState } from 'react';

/**
 * BookingModal Component
 * 
 * Modal dialog for booking tickets
 * Contains form with customer name, email, and number of seats
 */

interface BookingModalProps {
    event: Event;
    onClose: () => void;
    onSuccess: () => void;
}

export default function BookingModal({ event, onClose, onSuccess }: BookingModalProps) {
    // Form state
    const [customerName, setCustomerName] = useState('');
    const [customerEmail, setCustomerEmail] = useState('');
    const [numberOfSeats, setNumberOfSeats] = useState(1);

    // UI state
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);
    const [success, setSuccess] = useState(false);

    /**
     * Handle form submission
     */
    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setError(null);
        setLoading(true);

        try {
            // Create booking request
            const bookingData: BookingRequest = {
                eventId: event.id,
                customerName,
                customerEmail,
                numberOfSeats,
            };

            // Call API
            const response = await createBooking(bookingData);

            // Show success message
            setSuccess(true);

            // Close modal after 2 seconds
            setTimeout(() => {
                onSuccess();
            }, 2000);

        } catch (err) {
            // Show error message
            setError(err instanceof Error ? err.message : 'Failed to create booking');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="modal-overlay" onClick={onClose}>
            <div className="modal-content" onClick={(e) => e.stopPropagation()}>
                {/* Modal Header */}
                <div className="modal-header">
                    <h2>Book Tickets</h2>
                    <button className="close-button" onClick={onClose}>×</button>
                </div>

                {/* Event Info */}
                <div className="modal-event-info">
                    <h3>{event.name}</h3>
                    <p>{event.venue}</p>
                    <p className="available-seats">
                        {event.availableSeats} seats available
                    </p>
                </div>

                {/* Success Message */}
                {success ? (
                    <div className="success-message">
                        <div className="success-icon">✓</div>
                        <h3>Booking Successful!</h3>
                        <p>Check your email for confirmation details.</p>
                    </div>
                ) : (
                    /* Booking Form */
                    <form onSubmit={handleSubmit}>
                        {/* Name Input */}
                        <div className="form-group">
                            <label htmlFor="name">Full Name</label>
                            <input
                                id="name"
                                type="text"
                                value={customerName}
                                onChange={(e) => setCustomerName(e.target.value)}
                                required
                                placeholder="Enter your full name"
                            />
                        </div>

                        {/* Email Input */}
                        <div className="form-group">
                            <label htmlFor="email">Email Address</label>
                            <input
                                id="email"
                                type="email"
                                value={customerEmail}
                                onChange={(e) => setCustomerEmail(e.target.value)}
                                required
                                placeholder="your.email@example.com"
                            />
                        </div>

                        {/* Number of Seats */}
                        <div className="form-group">
                            <label htmlFor="seats">Number of Seats</label>
                            <input
                                id="seats"
                                type="number"
                                min="1"
                                max={event.availableSeats}
                                value={numberOfSeats}
                                onChange={(e) => setNumberOfSeats(parseInt(e.target.value))}
                                required
                            />
                        </div>

                        {/* Error Message */}
                        {error && (
                            <div className="error-message">
                                {error}
                            </div>
                        )}

                        {/* Submit Button */}
                        <button
                            type="submit"
                            className="submit-button"
                            disabled={loading}
                        >
                            {loading ? 'Processing...' : `Book ${numberOfSeats} Seat${numberOfSeats > 1 ? 's' : ''}`}
                        </button>
                    </form>
                )}
            </div>
        </div>
    );
}
