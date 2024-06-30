package org.behavioral.visitor.orderprocessing.visitors;

import org.behavioral.visitor.orderprocessing.elements.DigitalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.PhysicalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.SubscriptionOrder;

public class PricingVisitor implements OrderVisitor
{
    private double totalPrice = 0;

    @Override
    public void visit(PhysicalProductOrder order)
    {
        totalPrice += order.getPrice();
    }

    @Override
    public void visit(DigitalProductOrder order)
    {
        totalPrice += order.getPrice();
    }

    @Override
    public void visit(SubscriptionOrder order)
    {
        totalPrice += order.getMonthlyFee() * order.getMonths();
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }
}
