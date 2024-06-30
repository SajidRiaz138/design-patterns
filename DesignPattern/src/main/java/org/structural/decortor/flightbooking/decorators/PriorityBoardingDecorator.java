package org.structural.decortor.flightbooking.decorators;

import org.structural.decortor.flightbooking.component.FlightBooking;

/**
 * The PriorityBoardingDecorator class adds priority boarding to the flight booking.
 */
public class PriorityBoardingDecorator extends FlightBookingDecorator
{
    public PriorityBoardingDecorator(FlightBooking decoratedBooking)
    {
        super(decoratedBooking);
    }

    @Override
    public double getCost()
    {
        return super.getCost() + 30.0; // adding the cost of priority boarding
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " + Priority Boarding";
    }
}
