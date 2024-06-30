package org.structural.flyweight.bookseat.flyweightfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * SeatFactory creates and manages SeatType objects.
 */
public class SeatFactory
{
    private static final Map<String, SeatType> seatTypes = new HashMap<>();

    public static SeatType getSeatType(SeatPosition location, SeatClass seatClass, LegRoom legroom)
    {
        String key = location + "-" + seatClass + "-" + legroom;
        SeatType seatType = seatTypes.get(key);
        if (seatType == null)
        {
            seatType = new SeatType(location, seatClass, legroom);
            seatTypes.put(key, seatType);
        }
        return seatType;
    }
}
