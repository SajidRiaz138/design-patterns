package org.behavioral.statemachine;

import java.util.logging.Logger;

/**
 * The OrderService class provides methods to manage orders and handle state transitions.
 */
public class OrderService
{
    private static final Logger logger = Logger.getLogger(OrderService.class.getName());

    public Order createOrder(String orderId, String customer, String items)
    {
        logger.info("Creating new order: " + orderId);
        return new Order(orderId, customer, items);
    }

    public void processOrder(Order order)
    {
        logger.info("Processing order: " + order.getOrderId());
        order.confirmOrder();
        order.shipOrder();
        order.deliverOrder();
    }

    public void cancelOrder(Order order)
    {
        logger.info("Cancelling order: " + order.getOrderId());
        order.cancelOrder();
    }
}
