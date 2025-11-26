#!/bin/bash

# Check for Java
if ! command -v java &> /dev/null; then
    echo "Error: Java is not installed."
    echo "Please install Java 21. See SETUP_MAC.md for instructions."
    exit 1
fi

# Check for Maven
if ! command -v mvn &> /dev/null; then
    echo "Error: Maven is not installed."
    echo "Please install Maven. See SETUP_MAC.md for instructions."
    exit 1
fi

echo "Starting Ticket Booking Backend..."
cd ticket-booking-backend
mvn spring-boot:run
