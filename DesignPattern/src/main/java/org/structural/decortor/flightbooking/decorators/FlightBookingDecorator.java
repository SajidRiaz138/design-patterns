package org.structural.decortor.flightbooking.decorators;

import org.structural.decortor.flightbooking.component.FlightBooking;

/**
 * The FlightBookingDecorator class implements FlightBooking and serves as a base class for all flight booking decorators.
 */
public abstract class FlightBookingDecorator implements FlightBooking
{
    protected FlightBooking decoratedBooking;

    public FlightBookingDecorator(FlightBooking decoratedBooking)
    {
        this.decoratedBooking = decoratedBooking;
    }

    @Override
    public double getCost()
    {
        return decoratedBooking.getCost();
    }

    @Override
    public String getDescription()
    {
        return decoratedBooking.getDescription();
    }
}
