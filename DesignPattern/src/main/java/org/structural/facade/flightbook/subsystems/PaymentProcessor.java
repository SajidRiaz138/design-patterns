package org.structural.facade.flightbook.subsystems;

/**
 * PaymentProcessor handles the payment processing for bookings.
 */
public class PaymentProcessor
{

    /**
     * Processes the payment using specified payment details and method.
     *
     * @param paymentDetails the payment details
     * @param paymentMethod  the payment method
     * @return true if payment is successful, otherwise false
     */
    public boolean processPayment(String paymentDetails, String paymentMethod)
    {
        System.out.println("Processing payment with details: " + paymentDetails + " using method: " + paymentMethod);
        return true; // Assume payment is successful for this example
    }
}
