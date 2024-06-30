package org.structural.flyweight.bookseat.client;

import org.structural.flyweight.bookseat.flyweightfactory.LegRoom;
import org.structural.flyweight.bookseat.flyweightfactory.SeatClass;
import org.structural.flyweight.bookseat.flyweightfactory.SeatPosition;

public class SeatBookingApplication
{
    public static void main(String[] args)
    {
        Flight flight = new Flight();

        // Adding seats to the flight
        flight.addSeat(1, SeatPosition.WINDOW, SeatClass.ECONOMY, LegRoom.STANDARD);
        flight.addSeat(2, SeatPosition.AISLE, SeatClass.ECONOMY, LegRoom.STANDARD);
        flight.addSeat(3, SeatPosition.MIDDLE, SeatClass.ECONOMY, LegRoom.STANDARD);
        flight.addSeat(4, SeatPosition.WINDOW, SeatClass.BUSINESS, LegRoom.EXTRA);
        flight.addSeat(5, SeatPosition.AISLE, SeatClass.BUSINESS, LegRoom.EXTRA);

        // Displaying all seats
        System.out.println("All seats:");
        flight.displaySeats();

        // Booking a seat
        System.out.println("\nBooking seat 2:");
        flight.bookSeat(2);
        flight.displaySeats();

        // Canceling a booking
        System.out.println("\nCanceling seat 2:");
        flight.cancelSeat(2);
        flight.displaySeats();
    }
}
