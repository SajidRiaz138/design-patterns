package org.behavioral.visitor.orderprocessing.elements;

import org.behavioral.visitor.orderprocessing.visitors.OrderVisitor;

import java.util.ArrayList;
import java.util.List;

public class ECommercePlatform
{
    private List<Order> orders;

    public ECommercePlatform()
    {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order)
    {
        orders.add(order);
    }

    public void processOrders(OrderVisitor visitor)
    {
        for (Order order : orders)
        {
            order.accept(visitor);
        }
    }
}
