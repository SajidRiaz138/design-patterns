package org.structural.proxy.flightbookaccess.proxy;

import org.structural.proxy.flightbookaccess.subject.FlightBooking;
import org.structural.proxy.flightbookaccess.subject.RealFlightBooking;

import java.util.HashSet;
import java.util.Set;

/**
 * FlightBookingProxy controls access to the RealFlightBooking object.
 */
public class FlightBookingProxy implements FlightBooking
{
    private RealFlightBooking realFlightBooking = new RealFlightBooking();
    private Set<String> authorizedUsers;

    public FlightBookingProxy()
    {
        authorizedUsers = new HashSet<>();
        // Adding some authorized users for demonstration
        authorizedUsers.add("user12377878");
        authorizedUsers.add("user123456");
    }

    @Override
    public void bookFlight(String userId, String flightId)
    {
        if (authorizedUsers.contains(userId))
        {
            realFlightBooking.bookFlight(userId, flightId);
        }
        else
        {
            System.out.println("User " + userId + " is not authorized to book flights.");
        }
    }
}
