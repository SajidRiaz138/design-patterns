package org.structural.facade.flightbook.subsystems;

import java.util.HashMap;
import java.util.Map;

/**
 * BookingManager handles the booking of flights.
 */
public class BookingManager
{
    private Map<String, Booking> bookings = new HashMap<>();

    /**
     * Books a flight for a passenger.
     *
     * @param flightId       the ID of the flight
     * @param passengerDetails the details of the passenger
     * @param seatSelection  the seat selected by the passenger
     * @return a booking reference number
     */
    public String bookFlight(String flightId, String passengerDetails, String seatSelection)
    {
        System.out.println("Booking flight " + flightId + " for passenger: " + passengerDetails + " with seat selection: " + seatSelection);
        String bookingReference = "BOOK" + (bookings.size() + 1);
        bookings.put(bookingReference, new Booking(flightId, passengerDetails, seatSelection));
        return bookingReference;
    }

    /**
     * Booking represents a flight booking with details.
     */
    public record Booking(String flightId, String passengerDetails, String seatSelection) {
    }
}
