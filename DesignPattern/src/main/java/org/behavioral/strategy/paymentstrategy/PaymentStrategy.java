package org.behavioral.strategy.paymentstrategy;

public interface PaymentStrategy
{
    void validateDetails() throws InvalidPaymentException;

    void pay(double amount) throws PaymentException;
}
