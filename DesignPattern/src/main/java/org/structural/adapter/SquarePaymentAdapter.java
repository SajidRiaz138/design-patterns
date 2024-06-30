package org.structural.adapter;

import java.util.logging.Logger;

/**
 * The SquarePaymentAdapter class adapts the SquareService to the PaymentService interface.
 */
public class SquarePaymentAdapter implements PaymentService
{
    private static final Logger LOGGER = Logger.getLogger(SquarePaymentAdapter.class.getName());
    private final SquareService squareService;

    public SquarePaymentAdapter(SquareService squareService)
    {
        this.squareService = squareService;
    }

    @Override
    public void processPayment(String accountNumber, double amount) throws PaymentException
    {
        try
        {
            LOGGER.info("Starting payment process for account " + accountNumber + " with amount $" + amount);
            squareService.executePayment(accountNumber, amount);
            LOGGER.info("Payment processed successfully for account " + accountNumber);
        }
        catch (Exception e)
        {
            LOGGER.severe("Payment processing failed for account " + accountNumber + ": " + e.getMessage());
            throw new PaymentException("Payment processing failed for account " + accountNumber, e);
        }
    }
}
