package org.behavioral.statemachine;

/**
 * Exception class for handling errors during state transitions in an Order.
 */
public class OrderStateException extends Exception
{
    public OrderStateException(String message)
    {
        super(message);
    }
}
