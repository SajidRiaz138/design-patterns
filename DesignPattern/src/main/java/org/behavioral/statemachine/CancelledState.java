package org.behavioral.statemachine;

import java.util.logging.Logger;

/**
 * The CancelledState class represents the state of an order that has been cancelled.
 */
public class CancelledState implements State
{
    private static final Logger logger = Logger.getLogger(CancelledState.class.getName());

    @Override
    public void confirmOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Cancelled order cannot be confirmed.");
    }

    @Override
    public void shipOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Cancelled order cannot be shipped.");
    }

    @Override
    public void deliverOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Cancelled order cannot be delivered.");
    }

    @Override
    public void cancelOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order is already cancelled.");
    }
}
