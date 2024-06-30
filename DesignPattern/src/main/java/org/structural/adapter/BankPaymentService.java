package org.structural.adapter;

import java.util.logging.Logger;

/**
 * The BankPaymentService class implements the PaymentService interface.
 * This class provides methods to process payments using the bank's internal system.
 */
public class BankPaymentService implements PaymentService
{
    private static final Logger LOGGER = Logger.getLogger(BankPaymentService.class.getName());

    @Override
    public void processPayment(String accountNumber, double amount)
    {
        LOGGER.info("Processing payment of $" + amount + " for account " + accountNumber + " using BankPaymentService.");
        // Simulate payment processing logic...
    }
}
