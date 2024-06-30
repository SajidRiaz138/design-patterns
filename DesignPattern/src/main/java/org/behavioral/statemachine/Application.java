package org.behavioral.statemachine;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Application
{
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());
    public static void main(String[] args)
    {
        OrderService orderService = new OrderService();

        // Scenario 1: Normal order processing
        LOGGER.log(Level.INFO, "Scenario 1: Normal order processing");
        Order order1 = orderService.createOrder("1", "Alice", "Item1, Item2");
        orderService.processOrder(order1);
        order1.cancelOrder(); // Should not be possible since the order is already delivered

        // Scenario 2: Order is cancelled before processing

        LOGGER.log(Level.INFO, "Scenario 2: Order is cancelled before processing");
        Order order2 = orderService.createOrder("2", "Bob", "Item3, Item4");
        orderService.cancelOrder(order2); // Order cancelled in the New state


        // Scenario 3: Order is cancelled during processing
        LOGGER.log(Level.INFO, "Scenario 3: Order is cancelled during processing");
        Order order3 = orderService.createOrder("3", "Charlie", "Item5, Item6");
        order3.confirmOrder();
        orderService.cancelOrder(order3); // Order cancelled in the Processing state

        System.out.println();

        // Scenario 4: Attempt to cancel an already shipped order

        LOGGER.log(Level.INFO, "Scenario 4: Attempt to cancel an already shipped order");
        Order order4 = orderService.createOrder("4", "Dave", "Item7, Item8");
        order4.confirmOrder();
        order4.shipOrder();
        orderService.cancelOrder(order4); // Should not be possible since the order is already shipped

    }
}
