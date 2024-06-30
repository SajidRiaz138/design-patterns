package org.structural.decortor.flightbooking.decorators;

import org.structural.decortor.flightbooking.component.FlightBooking;

/**
* The LoungeAccessDecorator class adds lounge access to the flight booking.
*/
public class LoungeAccessDecorator extends FlightBookingDecorator
{
    public LoungeAccessDecorator(FlightBooking decoratedBooking)
    {
        super(decoratedBooking);
    }

    @Override
    public double getCost()
    {
        return super.getCost() + 50.0; // adding the cost of lounge access
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " + Lounge Access";
    }
}
