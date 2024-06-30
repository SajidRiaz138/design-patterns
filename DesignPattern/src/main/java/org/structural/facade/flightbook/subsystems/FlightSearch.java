package org.structural.facade.flightbook.subsystems;

import java.util.ArrayList;
import java.util.List;

/**
 * FlightSearch is responsible for searching available flights based on criteria.
 */
public class FlightSearch
{

    /**
     * Searches for flights based on origin, destination, and departure date.
     *
     * @param origin        the starting location
     * @param destination   the destination location
     * @param departureDate the departure date
     * @return a list of available flights
     */
    public List<Flight> searchFlights(String origin, String destination, String departureDate)
    {
        System.out.println("Searching for flights from " + origin + " to " + destination + " on " + departureDate);

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("FL123", origin, destination, departureDate, 300.0, 10));
        flights.add(new Flight("FL456", origin, destination, departureDate, 350.0, 5));

        return flights;
    }

    /**
     * Flight represents a flight with details such as flight ID, origin, destination, etc.
     */
    public record Flight(String flightId, String origin, String destination, String departureDate, double price, int availableSeats) {
    }
}
