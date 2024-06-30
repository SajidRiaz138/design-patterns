package org.behavioral.observer;

import java.util.*;

/**
 * The NotificationService class manages the subscription and notification
 * of events to listeners. It serves as the Subject in the Observer Pattern.
 */
public class NotificationService
{
    private final Map<Event, List<Listener>> customers;

    public NotificationService()
    {
        customers = new HashMap<>();
        for (Event event : Event.values())
        {
            customers.put(event, new ArrayList<>());
        }
    }

    public void subscribe(Event event, Listener listener)
    {
        customers.get(event).add(listener);
    }

    public void unsubscribe(Event event, Listener listener)
    {
        customers.get(event).remove(listener);
    }

    public void notify(Event event, String movieTitle)
    {
        for (Listener listener : customers.get(event))
        {
            listener.update(event, movieTitle);
        }
    }
}
