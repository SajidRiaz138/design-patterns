package org.structural.decortor.flightbooking.decorators;

import org.structural.decortor.flightbooking.component.FlightBooking;

/**
 * The InFlightMealDecorator class adds an in-flight meal to the flight booking.
 */
public class InFlightMealDecorator extends FlightBookingDecorator
{
    public InFlightMealDecorator(FlightBooking decoratedBooking)
    {
        super(decoratedBooking);
    }

    @Override
    public double getCost()
    {
        return super.getCost() + 20.0; // adding the cost of in-flight meal
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " + In-Flight Meal";
    }
}
