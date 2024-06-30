package org.structural.decortor.flightbooking.decorators;

import org.structural.decortor.flightbooking.component.FlightBooking;

/**
 * The SeatUpgradeDecorator class adds a seat upgrade to the flight booking.
 */
public class SeatUpgradeDecorator extends FlightBookingDecorator
{
    public SeatUpgradeDecorator(FlightBooking decoratedBooking)
    {
        super(decoratedBooking);
    }

    @Override
    public double getCost()
    {
        return super.getCost() + 100.0; // adding the cost of seat upgrade
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " + Seat Upgrade";
    }
}
