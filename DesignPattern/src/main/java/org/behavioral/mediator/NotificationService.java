package org.behavioral.mediator;

public class NotificationService
{
    public void notify(Cart cart)
    {
        // Simulate notification logic
        System.out.println("Sending notification for items: " + cart.getItems());
    }

    public void sendCancellation(Cart cart)
    {
        // Simulate cancellation notification logic
        System.out.println("Sending cancellation notification for items: " + cart.getItems());
    }
}
