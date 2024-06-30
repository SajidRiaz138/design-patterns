package org.structural.proxy.flightbookaccess.subject;

/**
 * RealFlightBooking is the real object that implements the FlightBooking interface.
 */
public class RealFlightBooking implements FlightBooking
{
    @Override
    public void bookFlight(String userId, String flightId)
    {
        System.out.println("Booking flight " + flightId + " for user " + userId);
    }
}
