package org.behavioral.chain.handlers;

/**
 * The CreditCardHandler class handles payments made with a credit card.
 */
public class CreditCardHandler extends AbstractPaymentHandler
{
    @Override
    public String getPaymentMethod()
    {
        return "credit_card";
    }

    @Override
    protected void processPayment(PaymentRequest request)
    {
        logger.info("Processing credit card payment of $" + request.getAmount());
        // Perform credit card payment processing logic here
    }
}
