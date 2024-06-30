package org.behavioral.statemachine;

/**
 * The State interface defines the behavior associated with a particular state of an Order.
 */
public interface State
{
    void confirmOrder(Order context) throws OrderStateException;

    void shipOrder(Order context) throws OrderStateException;

    void deliverOrder(Order context) throws OrderStateException;

    void cancelOrder(Order context) throws OrderStateException;
}
