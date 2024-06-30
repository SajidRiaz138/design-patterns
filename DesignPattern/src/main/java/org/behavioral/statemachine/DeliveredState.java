package org.behavioral.statemachine;

import java.util.logging.Logger;

/**
 * The DeliveredState class represents the state of an order that has been delivered.
 */
public class DeliveredState implements State
{
    private static final Logger logger = Logger.getLogger(DeliveredState.class.getName());

    @Override
    public void confirmOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order is already confirmed.");
    }

    @Override
    public void shipOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order is already delivered and cannot be shipped again.");
    }

    @Override
    public void deliverOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order is already delivered.");
    }

    @Override
    public void cancelOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order cannot be cancelled after it has been delivered.");
    }
}
