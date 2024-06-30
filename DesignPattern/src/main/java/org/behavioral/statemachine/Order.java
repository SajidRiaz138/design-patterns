package org.behavioral.statemachine;

import java.util.logging.Logger;

/**
 * The Order class maintains the current state of the order and allows state transitions.
 * It also simulates persistence by saving and loading the state.
 */
public class Order
{
    private static final Logger logger = Logger.getLogger(Order.class.getName());
    private State currentState;
    private String orderId;
    private String customer;
    private String items;

    public Order(String orderId, String customer, String items)
    {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.currentState = new NewState(); // Default state
    }

    public void setState(State state)
    {
        this.currentState = state;
    }

    public void confirmOrder()
    {
        try
        {
            currentState.confirmOrder(this);
        }
        catch (OrderStateException e)
        {
            logger.severe(e.getMessage());
        }
    }

    public void shipOrder()
    {
        try
        {
            currentState.shipOrder(this);
        }
        catch (OrderStateException e)
        {
            logger.severe(e.getMessage());
        }
    }

    public void deliverOrder()
    {
        try
        {
            currentState.deliverOrder(this);
        }
        catch (OrderStateException e)
        {
            logger.severe(e.getMessage());
        }
    }

    public void cancelOrder()
    {
        try
        {
            currentState.cancelOrder(this);
        }
        catch (OrderStateException e)
        {
            logger.severe(e.getMessage());
        }
    }

    public void saveState()
    {
        // Simulate saving state to a database
        logger.info("Order " + orderId + " state saved: " + currentState.getClass().getSimpleName());
    }

    public void loadState()
    {
        // Simulate loading state from a database
        logger.info("Order " + orderId + " state loaded: " + currentState.getClass().getSimpleName());
    }

    // Additional methods for order details
    public String getOrderId()
    {
        return orderId;
    }

    public String getCustomer()
    {
        return customer;
    }

    public String getItems()
    {
        return items;
    }
}
