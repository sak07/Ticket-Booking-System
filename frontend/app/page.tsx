'use client';

import { useEffect, useState } from 'react';
import { Event } from '@/types';
import { fetchEvents } from '@/services/api';
import EventCard from '@/components/EventCard';
import ThemeToggle from '@/components/ThemeToggle';

/**
 * Home Page - Main page of the application
 * 
 * Displays all available events in a grid layout
 * Automatically refreshes events after successful bookings
 */

export default function Home() {
  // State for events and loading
  const [events, setEvents] = useState<Event[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  /**
   * Load events from API
   */
  const loadEvents = async () => {
    try {
      setLoading(true);
      setError(null);
      const data = await fetchEvents();
      setEvents(data);
    } catch (err) {
      setError('Failed to load events. Please try again later.');
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  // Load events when component mounts
  useEffect(() => {
    loadEvents();
  }, []);

  return (
    <div className="container">
      <ThemeToggle />

      {/* Header */}
      <header className="header">
        <h1 className="main-title">🎟️ Ticket Booking System</h1>
        <p className="subtitle">Book your tickets for amazing events</p>
      </header>

      {/* Loading State */}
      {loading && (
        <div className="loading">
          <div className="spinner"></div>
          <p>Loading events...</p>
        </div>
      )}

      {/* Error State */}
      {error && (
        <div className="error-banner">
          {error}
        </div>
      )}

      {/* Events Grid */}
      {!loading && !error && (
        <div className="events-grid">
          {events.length === 0 ? (
            <p className="no-events">No events available at the moment.</p>
          ) : (
            events.map((event) => (
              <EventCard
                key={event.id}
                event={event}
                onBookingSuccess={loadEvents} // Refresh events after booking
              />
            ))
          )}
        </div>
      )}
    </div>
  );
}
