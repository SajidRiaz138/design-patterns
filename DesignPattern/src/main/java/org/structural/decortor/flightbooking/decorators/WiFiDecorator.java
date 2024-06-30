package org.structural.decortor.flightbooking.decorators;

import org.structural.decortor.flightbooking.component.FlightBooking;

/**
 * The WiFiDecorator class adds Wi-Fi to the flight booking.
 */
public class WiFiDecorator extends FlightBookingDecorator
{
    public WiFiDecorator(FlightBooking decoratedBooking)
    {
        super(decoratedBooking);
    }

    @Override
    public double getCost()
    {
        return super.getCost() + 10.0; // adding the cost of Wi-Fi
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " + Wi-Fi";
    }
}
