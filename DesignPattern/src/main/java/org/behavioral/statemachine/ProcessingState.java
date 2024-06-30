package org.behavioral.statemachine;

import java.util.logging.Logger;

/**
 * The ProcessingState class represents the state of an order that is being processed.
 */
public class ProcessingState implements State
{
    private static final Logger logger = Logger.getLogger(ProcessingState.class.getName());

    @Override
    public void confirmOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order is already confirmed.");
    }

    @Override
    public void shipOrder(Order context)
    {
        logger.info("Order shipped.");
        context.setState(new ShippedState());
        context.saveState();
    }

    @Override
    public void deliverOrder(Order context) throws OrderStateException
    {
        throw new OrderStateException("Order cannot be delivered directly from the processing state.");
    }

    @Override
    public void cancelOrder(Order context)
    {
        logger.info("Order cancelled.");
        context.setState(new CancelledState());
        context.saveState();
    }
}
