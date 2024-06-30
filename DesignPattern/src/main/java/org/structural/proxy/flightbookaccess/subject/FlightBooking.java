package org.structural.proxy.flightbookaccess.subject;

/**
 * FlightBooking interface defines the operations for booking flights.
 */
public interface FlightBooking
{
    void bookFlight(String userId, String flightId);
}
