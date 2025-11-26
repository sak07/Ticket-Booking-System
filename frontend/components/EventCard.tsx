'use client';

import { Event } from '@/types';
import { useState } from 'react';
import BookingModal from './BookingModal';

/**
 * EventCard Component
 * 
 * Displays a single event with its details and a "Book Now" button
 * Opens booking modal when button is clicked
 */

interface EventCardProps {
    event: Event;
    onBookingSuccess: () => void; // Callback to refresh events after booking
}

export default function EventCard({ event, onBookingSuccess }: EventCardProps) {
    const [showBookingModal, setShowBookingModal] = useState(false);

    // Format date for display
    const eventDate = new Date(event.eventDate);
    const formattedDate = eventDate.toLocaleDateString('en-US', {
        weekday: 'long',
        year: 'numeric',
        month: 'long',
        day: 'numeric',
    });
    const formattedTime = eventDate.toLocaleTimeString('en-US', {
        hour: '2-digit',
        minute: '2-digit',
    });

    return (
        <>
            <div className="event-card">
                {/* Event Header */}
                <div className="event-header">
                    <h2 className="event-title">{event.name}</h2>
                    <div className="event-seats">
                        <span className="seats-available">{event.availableSeats}</span>
                        <span className="seats-label">/ {event.totalSeats} seats</span>
                    </div>
                </div>

                {/* Event Details */}
                <p className="event-description">{event.description}</p>

                <div className="event-info">
                    <div className="info-item">
                        <span className="info-icon">📅</span>
                        <span>{formattedDate}</span>
                    </div>
                    <div className="info-item">
                        <span className="info-icon">🕐</span>
                        <span>{formattedTime}</span>
                    </div>
                    <div className="info-item">
                        <span className="info-icon">📍</span>
                        <span>{event.venue}</span>
                    </div>
                </div>

                {/* Book Button */}
                <button
                    className="book-button"
                    onClick={() => setShowBookingModal(true)}
                    disabled={event.availableSeats === 0}
                >
                    {event.availableSeats === 0 ? 'Sold Out' : 'Book Now'}
                </button>
            </div>

            {/* Booking Modal */}
            {showBookingModal && (
                <BookingModal
                    event={event}
                    onClose={() => setShowBookingModal(false)}
                    onSuccess={() => {
                        setShowBookingModal(false);
                        onBookingSuccess(); // Refresh events list
                    }}
                />
            )}
        </>
    );
}
