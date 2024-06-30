package org.structural.flyweight.bookseat.context;

import org.structural.flyweight.bookseat.flyweightfactory.SeatPosition;
import org.structural.flyweight.bookseat.flyweightfactory.SeatType;

/**
 * Seat represents the extrinsic state (seat number and availability) of a seat.
 */
public class Seat
{
    private final int seatNumber;
    private final SeatType seatType;
    private boolean isAvailable;

    public Seat(int seatNumber, SeatType seatType)
    {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isAvailable = true;
    }

    public void book()
    {
        isAvailable = false;
    }

    public void cancel()
    {
        isAvailable = true;
    }

    public void display()
    {
        seatType.display(seatNumber, isAvailable);
    }

    public int getSeatNumber()
    {
        return seatNumber;
    }
}
