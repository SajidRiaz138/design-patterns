package org.structural.decortor.flightbooking.component;

/**
 * The BaseFlightBooking class represents a simple flight booking without any additional features.
 */
public class BaseFlightBooking implements FlightBooking
{
    private String flight;
    private double price;

    public BaseFlightBooking(String flight, double price)
    {
        this.flight = flight;
        this.price = price;
    }

    @Override
    public double getCost()
    {
        return price;
    }

    @Override
    public String getDescription()
    {
        return flight;
    }
}
