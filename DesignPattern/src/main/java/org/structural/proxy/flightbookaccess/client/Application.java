package org.structural.proxy.flightbookaccess.client;

import org.structural.proxy.flightbookaccess.proxy.FlightBookingProxy;
import org.structural.proxy.flightbookaccess.subject.FlightBooking;

public class Application
{
    public static void main(String[] args)
    {
        FlightBooking flightBooking = new FlightBookingProxy();

        // Authorized user booking a flight
        flightBooking.bookFlight("user12377878", "FL123");

        // Unauthorized user trying to book a flight
        flightBooking.bookFlight("user123456", "FL456");
    }
}
