package org.structural.decortor.flightbooking.client;

import org.structural.decortor.flightbooking.component.BaseFlightBooking;
import org.structural.decortor.flightbooking.component.FlightBooking;
import org.structural.decortor.flightbooking.decorators.ExtraBaggageDecorator;
import org.structural.decortor.flightbooking.decorators.InFlightMealDecorator;
import org.structural.decortor.flightbooking.decorators.LoungeAccessDecorator;
import org.structural.decortor.flightbooking.decorators.PriorityBoardingDecorator;
import org.structural.decortor.flightbooking.decorators.SeatUpgradeDecorator;
import org.structural.decortor.flightbooking.decorators.TravelInsuranceDecorator;
import org.structural.decortor.flightbooking.decorators.WiFiDecorator;

public class FlightBookingClient
{
    public static void main(String[] args)
    {
        FlightBooking basicBooking = new BaseFlightBooking("Flight 123", 200.0);
        System.out.println(basicBooking.getDescription() + " $" + basicBooking.getCost());

        FlightBooking priorityBoardingBooking = new PriorityBoardingDecorator(basicBooking);
        System.out.println(priorityBoardingBooking.getDescription() + " $" + priorityBoardingBooking.getCost());

        FlightBooking extraBaggageBooking = new ExtraBaggageDecorator(priorityBoardingBooking);
        System.out.println(extraBaggageBooking.getDescription() + " $" + extraBaggageBooking.getCost());

        FlightBooking inFlightMealBooking = new InFlightMealDecorator(extraBaggageBooking);
        System.out.println(inFlightMealBooking.getDescription() + " $" + inFlightMealBooking.getCost());

        FlightBooking seatUpgradeBooking = new SeatUpgradeDecorator(inFlightMealBooking);
        System.out.println(seatUpgradeBooking.getDescription() + " $" + seatUpgradeBooking.getCost());

        FlightBooking travelInsuranceBooking = new TravelInsuranceDecorator(seatUpgradeBooking);
        System.out.println(travelInsuranceBooking.getDescription() + " $" + travelInsuranceBooking.getCost());

        FlightBooking loungeAccessBooking = new LoungeAccessDecorator(travelInsuranceBooking);
        System.out.println(loungeAccessBooking.getDescription() + " $" + loungeAccessBooking.getCost());

        FlightBooking wifiBooking = new WiFiDecorator(loungeAccessBooking);
        System.out.println(wifiBooking.getDescription() + " $" + wifiBooking.getCost());

    }
}
