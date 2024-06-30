package org.structural.decortor.flightbooking.decorators;

import org.structural.decortor.flightbooking.component.FlightBooking;

/**
 * The TravelInsuranceDecorator class adds travel insurance to the flight booking.
 */
public class TravelInsuranceDecorator extends FlightBookingDecorator
{
    public TravelInsuranceDecorator(FlightBooking decoratedBooking)
    {
        super(decoratedBooking);
    }

    @Override
    public double getCost()
    {
        return super.getCost() + 40.0; // adding the cost of travel insurance
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " + Travel Insurance";
    }
}
