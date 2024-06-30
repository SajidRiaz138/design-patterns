package org.behavioral.visitor.orderprocessing.visitors;

import org.behavioral.visitor.orderprocessing.elements.DigitalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.PhysicalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.SubscriptionOrder;

public class ShippingCostVisitor implements OrderVisitor
{
    private double totalShippingCost = 0;
    private static final double SHIPPING_RATE_PER_KG = 5.0; // Example rate

    @Override
    public void visit(PhysicalProductOrder order)
    {
        totalShippingCost += order.getWeight() * SHIPPING_RATE_PER_KG;
    }

    @Override
    public void visit(DigitalProductOrder order)
    {
        // Digital products have no shipping cost
    }

    @Override
    public void visit(SubscriptionOrder order)
    {
        // Subscriptions have no shipping cost
    }

    public double getTotalShippingCost()
    {
        return totalShippingCost;
    }
}
