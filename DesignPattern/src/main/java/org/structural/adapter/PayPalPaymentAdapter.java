package org.structural.adapter;

import java.util.logging.Logger;

/**
 * The PayPalPaymentAdapter class adapts the PayPalService to the PaymentService interface.
 */
public class PayPalPaymentAdapter implements PaymentService
{
    private static final Logger LOGGER = Logger.getLogger(PayPalPaymentAdapter.class.getName());
    private final PayPalService payPalService;

    public PayPalPaymentAdapter(PayPalService payPalService)
    {
        this.payPalService = payPalService;
    }

    @Override
    public void processPayment(String accountNumber, double amount) throws PaymentException
    {
        try
        {
            LOGGER.info("Starting payment process for account " + accountNumber + " with amount $" + amount);
            payPalService.sendPayment(accountNumber, amount);
            LOGGER.info("Payment processed successfully for account " + accountNumber);
        }
        catch (Exception e)
        {
            LOGGER.severe("Payment processing failed for account " + accountNumber + ": " + e.getMessage());
            throw new PaymentException("Payment processing failed for account " + accountNumber, e);
        }
    }
}
