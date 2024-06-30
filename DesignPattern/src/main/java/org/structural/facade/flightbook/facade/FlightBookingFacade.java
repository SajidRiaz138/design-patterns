package org.structural.facade.flightbook.facade;

import org.structural.facade.flightbook.subsystems.BookingManager;
import org.structural.facade.flightbook.subsystems.FlightSearch;
import org.structural.facade.flightbook.subsystems.NotificationService;
import org.structural.facade.flightbook.subsystems.PaymentProcessor;
import org.structural.facade.flightbook.subsystems.UserProfileManager;

import java.util.List;

/**
 * FlightBookingFacade provides a simplified interface to interact with the flight booking system.
 */
public class FlightBookingFacade
{
    private FlightSearch flightSearch;
    private BookingManager bookingManager;
    private PaymentProcessor paymentProcessor;
    private NotificationService notificationService;
    private UserProfileManager userProfileManager;

    public FlightBookingFacade()
    {
        this.flightSearch = new FlightSearch();
        this.bookingManager = new BookingManager();
        this.paymentProcessor = new PaymentProcessor();
        this.notificationService = new NotificationService();
        this.userProfileManager = new UserProfileManager();
    }

    /**
     * Adds a new user profile.
     *
     * @param userId         the user ID
     * @param name           the name of the user
     * @param contactDetails the contact details of the user
     */
    public void addUserProfile(String userId, String name, String contactDetails)
    {
        userProfileManager.addUserProfile(userId, name, contactDetails);
    }

    /**
     * Searches for flights based on the provided criteria.
     *
     * @param origin        the starting location
     * @param destination   the destination location
     * @param departureDate the departure date
     */
    public void searchFlights(String origin, String destination, String departureDate)
    {
        List<FlightSearch.Flight> flights = flightSearch.searchFlights(origin, destination, departureDate);
        for (FlightSearch.Flight flight : flights)
        {
            System.out.println(flight);
        }
    }

    /**
     * Books a flight for a user.
     *
     * @param userId         the user ID
     * @param flightId       the flight ID
     * @param seatSelection  the seat selected by the user
     * @param paymentDetails the payment details
     * @param paymentMethod  the payment method
     * @param notificationType the type of notification (e.g., SMS, Email)
     */
    public void bookFlight(String userId,
                           String flightId,
                           String seatSelection,
                           String paymentDetails,
                           String paymentMethod,
                           String notificationType)
    {
        UserProfileManager.UserProfile userProfile = userProfileManager.getUserProfile(userId);
        if (userProfile == null)
        {
            System.out.println("User profile not found for user ID: " + userId);
            return;
        }

        if (paymentProcessor.processPayment(paymentDetails, paymentMethod))
        {
            String bookingReference = bookingManager.bookFlight(flightId, userProfile.toString(), seatSelection);
            notificationService.sendBookingConfirmation(userProfile.toString(), bookingReference, notificationType);
            System.out.println("Flight booked successfully with booking reference: " + bookingReference);
        }
        else
        {
            System.out.println("Payment processing failed.");
        }
    }
}
