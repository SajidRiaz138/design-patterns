package org.behavioral.visitor.orderprocessing.elements;

import org.behavioral.visitor.orderprocessing.visitors.OrderVisitor;

public class SubscriptionOrder implements Order
{
    private double monthlyFee;
    private int months;

    public SubscriptionOrder(double monthlyFee, int months)
    {
        this.monthlyFee = monthlyFee;
        this.months = months;
    }

    public double getMonthlyFee()
    {
        return monthlyFee;
    }

    public int getMonths()
    {
        return months;
    }

    @Override
    public void accept(OrderVisitor visitor)
    {
        visitor.visit(this);
    }
}
