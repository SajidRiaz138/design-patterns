package org.structural.adapter;

/**
 * The StripeService class simulates an external payment service provided by Stripe.
 * This class provides methods to process payments using Stripe's API.
 */
public class StripeService
{
    public void makePayment(String cardNumber, double amount)
    {
        System.out.println("Processing payment of $" + amount + " for card " + cardNumber + " using StripeService.");
        // Simulate payment processing logic...
    }
}
