package org.behavioral.visitor.orderprocessing.visitors;

import org.behavioral.visitor.orderprocessing.elements.DigitalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.PhysicalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.SubscriptionOrder;

public class OrderValidationVisitor implements OrderVisitor
{
    private boolean allValid = true;

    @Override
    public void visit(PhysicalProductOrder order)
    {
        if (order.getPrice() <= 0 || order.getWeight() <= 0)
        {
            allValid = false;
        }
    }

    @Override
    public void visit(DigitalProductOrder order)
    {
        if (order.getPrice() <= 0)
        {
            allValid = false;
        }
    }

    @Override
    public void visit(SubscriptionOrder order)
    {
        if (order.getMonthlyFee() <= 0 || order.getMonths() <= 0)
        {
            allValid = false;
        }
    }

    public boolean isAllValid()
    {
        return allValid;
    }
}
