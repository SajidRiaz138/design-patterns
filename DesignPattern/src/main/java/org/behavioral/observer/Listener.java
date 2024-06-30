package org.behavioral.observer;

/**
 * The Listener interface defines the update method for listeners
 * in the Observer Pattern. Implementations of this interface will
 * handle specific notification methods such as email or phone notifications.
 */
public interface Listener
{
    /**
     * Updates the listener with information about an event.
     *
     * @param event      The event that occurred.
     * @param movieTitle The title of the movie related to the event.
     */
    void update(Event event, String movieTitle);
}
