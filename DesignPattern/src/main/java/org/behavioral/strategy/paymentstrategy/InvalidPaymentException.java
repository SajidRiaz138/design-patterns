package org.behavioral.strategy.paymentstrategy;

public class InvalidPaymentException extends Exception
{
    public InvalidPaymentException(String message)
    {
        super(message);
    }
}
