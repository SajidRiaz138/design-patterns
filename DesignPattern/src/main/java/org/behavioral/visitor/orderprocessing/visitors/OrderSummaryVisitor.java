package org.behavioral.visitor.orderprocessing.visitors;

import org.behavioral.visitor.orderprocessing.elements.DigitalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.PhysicalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.SubscriptionOrder;

public class OrderSummaryVisitor implements OrderVisitor
{
    private StringBuilder summary = new StringBuilder();

    @Override
    public void visit(PhysicalProductOrder order)
    {
        summary.append("Physical Product Order: Price = $")
                .append(order.getPrice())
                .append(", Weight = ")
                .append(order.getWeight())
                .append(" kg, Shipping Address = ")
                .append(order.getShippingAddress())
                .append("\n");
    }

    @Override
    public void visit(DigitalProductOrder order)
    {
        summary.append("Digital Product Order: Price = $")
                .append(order.getPrice())
                .append(", Download Link = ")
                .append(order.getDownloadLink())
                .append("\n");
    }

    @Override
    public void visit(SubscriptionOrder order)
    {
        summary.append("Subscription Order: Monthly Fee = $")
                .append(order.getMonthlyFee())
                .append(", Duration = ")
                .append(order.getMonths())
                .append(" months\n");
    }

    public String getSummary()
    {
        return summary.toString();
    }
}
