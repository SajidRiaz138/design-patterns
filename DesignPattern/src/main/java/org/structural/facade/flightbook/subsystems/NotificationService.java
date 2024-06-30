package org.structural.facade.flightbook.subsystems;

/**
 * NotificationService handles sending notifications to customers.
 */
public class NotificationService
{

    /**
     * Sends a booking confirmation to the passenger.
     *
     * @param passengerDetails  the details of the passenger
     * @param bookingReference  the booking reference number
     * @param notificationType  the type of notification (e.g., SMS, Email)
     */
    public void sendBookingConfirmation(String passengerDetails, String bookingReference, String notificationType)
    {
        System.out.println("Sending booking confirmation to passenger: " + passengerDetails + " with booking reference: " + bookingReference
                + " via " + notificationType);
    }
}
