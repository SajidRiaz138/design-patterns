package org.structural.adapter;

/**
 * The SquareService class simulates an external payment service provided by Square.
 * This class provides methods to process payments using Square's API.
 */
public class SquareService
{
    public void executePayment(String userId, double amount)
    {
        System.out.println("Processing payment of $" + amount + " for user ID " + userId + " using SquareService.");
        // Simulate payment processing logic...
    }
}
