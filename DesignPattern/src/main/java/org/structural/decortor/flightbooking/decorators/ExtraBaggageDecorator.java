package org.structural.decortor.flightbooking.decorators;

import org.structural.decortor.flightbooking.component.FlightBooking;

/**
 * The ExtraBaggageDecorator class adds extra baggage to the flight booking.
 */
public class ExtraBaggageDecorator extends FlightBookingDecorator
{
    public ExtraBaggageDecorator(FlightBooking decoratedBooking)
    {
        super(decoratedBooking);
    }

    @Override
    public double getCost()
    {
        return super.getCost() + 50.0; // adding the cost of extra baggage
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " + Extra Baggage";
    }
}
