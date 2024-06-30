package org.behavioral.chain.handlers;

/**
 * The PaymentProcessor interface defines the method for handling payment requests.
 */
public interface PaymentHandler
{
    void handle(PaymentRequest request);

    String getPaymentMethod();
}
