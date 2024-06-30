package org.structural.adapter;

/**
 * The PayPalService class simulates an external payment service provided by PayPal.
 * This class provides methods to process payments using PayPal's API.
 */
public class PayPalService
{
    public void sendPayment(String email, double amount)
    {
        System.out.println("Processing payment of $" + amount + " for email " + email + " using PayPalService.");
        // Simulate payment processing logic...
    }
}
