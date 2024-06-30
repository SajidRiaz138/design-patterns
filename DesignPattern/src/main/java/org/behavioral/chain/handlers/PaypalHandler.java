package org.behavioral.chain.handlers;

/**
 * The PaypalHandler class handles payments made with PayPal.
 */
public class PaypalHandler extends AbstractPaymentHandler
{
    @Override
    public String getPaymentMethod()
    {
        return "paypal";
    }

    @Override
    protected void processPayment(PaymentRequest request)
    {
        logger.info("Processing PayPal payment of $" + request.getAmount());
        // Perform PayPal payment processing logic here
    }
}
