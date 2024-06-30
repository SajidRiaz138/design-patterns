package org.structural.flyweight.bookseat.flyweightfactory;

/**
 * SeatType (FlyWeight) represents the intrinsic state shared by multiple Seat objects.
 */
public class SeatType
{
    private final SeatPosition position;
    private final SeatClass seatClass;
    private final LegRoom legroom;

    public SeatType(SeatPosition type, SeatClass seatClass, LegRoom legroom)
    {
        this.position = type;
        this.seatClass = seatClass;
        this.legroom = legroom;
    }

    public void display(int seatNumber, boolean isAvailable)
    {
        System.out.println("Seat " + seatNumber + " [" + position + ", " + seatClass + ", " + legroom + "] - " +
                (isAvailable ? "Available" : "Booked"));
    }
}
