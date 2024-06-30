package org.structural.facade.flightbook.client;

import org.structural.facade.flightbook.facade.FlightBookingFacade;

public class FlightBookingClient
{
    public static void main(String[] args)
    {
        FlightBookingFacade flightBookingFacade = new FlightBookingFacade();

        // Adding user profiles
        flightBookingFacade.addUserProfile("U123", "John Doe", "john.doe@example.com");
        flightBookingFacade.addUserProfile("U124", "Jane Smith", "jane.smith@example.com");

        // Searching for flights
        System.out.println("Searching for flights:");
        flightBookingFacade.searchFlights("NYC", "LAX", "2023-07-10");

        // Booking a flight
        System.out.println("\nBooking a flight:");
        flightBookingFacade.bookFlight("U123", "FL123", "12A", "CreditCardDetails", "CreditCard", "Email");
    }
}
