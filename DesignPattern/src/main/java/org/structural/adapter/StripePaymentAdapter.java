package org.structural.adapter;

import java.util.logging.Logger;

/**
 * The StripePaymentAdapter class adapts the StripeService to the PaymentService interface.
 */
public class StripePaymentAdapter implements PaymentService
{
    private static final Logger LOGGER = Logger.getLogger(StripePaymentAdapter.class.getName());
    private final StripeService stripeService;

    public StripePaymentAdapter(StripeService stripeService)
    {
        this.stripeService = stripeService;
    }

    @Override
    public void processPayment(String accountNumber, double amount) throws PaymentException
    {
        try
        {
            LOGGER.info("Starting payment process for account " + accountNumber + " with amount $" + amount);
            stripeService.makePayment(accountNumber, amount);
            LOGGER.info("Payment processed successfully for account " + accountNumber);
        }
        catch (Exception e)
        {
            LOGGER.severe("Payment processing failed for account " + accountNumber + ": " + e.getMessage());
            throw new PaymentException("Payment processing failed for account " + accountNumber, e);
        }
    }
}
