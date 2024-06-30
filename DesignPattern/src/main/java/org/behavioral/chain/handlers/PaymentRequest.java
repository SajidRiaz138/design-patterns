package org.behavioral.chain.handlers;

/**
 * The PaymentRequest class represents a payment request with an amount and payment method.
 */
public class PaymentRequest
{
    private double amount;
    private String paymentMethod;

    public PaymentRequest(double amount, String paymentMethod)
    {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getPaymentMethod()
    {
        return paymentMethod;
    }
}
