package org.structural.adapter;

public class PaymentException extends Exception
{
    public PaymentException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
