package org.structural.flyweight.bookseat.client;

import org.structural.flyweight.bookseat.context.Seat;
import org.structural.flyweight.bookseat.flyweightfactory.LegRoom;
import org.structural.flyweight.bookseat.flyweightfactory.SeatClass;
import org.structural.flyweight.bookseat.flyweightfactory.SeatFactory;
import org.structural.flyweight.bookseat.flyweightfactory.SeatPosition;
import org.structural.flyweight.bookseat.flyweightfactory.SeatType;

import java.util.ArrayList;
import java.util.List;

/**
 * Flight manages a collection of Seat objects.
 */
public class Flight
{
    private final List<Seat> seats = new ArrayList<>();

    public void addSeat(int seatNumber, SeatPosition type, SeatClass seatClass, LegRoom legroom)
    {
        SeatType seatType = SeatFactory.getSeatType(type, seatClass, legroom);
        Seat seat = new Seat(seatNumber, seatType);
        seats.add(seat);
    }

    public void bookSeat(int seatNumber)
    {
        for (Seat seat : seats)
        {
            if (seatNumber == seat.getSeatNumber())
            {
                seat.book();
                break;
            }
        }
    }

    public void cancelSeat(int seatNumber)
    {
        for (Seat seat : seats)
        {
            if (seatNumber == seat.getSeatNumber())
            {
                seat.cancel();
                break;
            }
        }
    }

    public void displaySeats()
    {
        for (Seat seat : seats)
        {
            seat.display();
        }
    }
}
