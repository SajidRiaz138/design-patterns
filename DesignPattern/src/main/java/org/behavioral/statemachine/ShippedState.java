package org.behavioral.statemachine;

import java.util.logging.Logger;

/**
 * The ShippedState class represents the state of an order that has been shipped.
 */
public class ShippedState implements State
{
    private static final Logger logger = Logger.getLogger(ShippedState.class.getName());

    @Override
    public void confirmOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order is already confirmed.");
    }

    @Override
    public void shipOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order is already shipped.");
    }

    @Override
    public void deliverOrder(Order context)
    {
        logger.info("Order delivered.");
        context.setState(new DeliveredState());
        context.saveState();
    }

    @Override
    public void cancelOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order cannot be cancelled after it has been shipped.");
    }
}
