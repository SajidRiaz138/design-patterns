package org.behavioral.statemachine;

import java.util.logging.Logger;

/**
 * The NewState class represents the state of a newly created order.
 */
public class NewState implements State
{
    private static final Logger logger = Logger.getLogger(NewState.class.getName());

    @Override
    public void confirmOrder(Order context)
    {
        logger.info("Order confirmed.");
        context.setState(new ProcessingState());
        context.saveState();
    }

    @Override
    public void shipOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order cannot be shipped directly from the new state.");
    }

    @Override
    public void deliverOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order cannot be delivered directly from the new state.");
    }

    @Override
    public void cancelOrder(Order context)
    {
        logger.info("Order cancelled.");
        context.setState(new CancelledState());
        context.saveState();
    }
}
