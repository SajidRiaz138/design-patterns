package org.behavioral.strategy.discountstrategies;

import java.util.List;

public class FixedAmountDiscount implements DiscountStrategy
{
    private double discountAmount;

    public FixedAmountDiscount(double discountAmount)
    {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double total, List<Item> items)
    {
        return total - discountAmount;
    }

    @Override
    public String toString()
    {
        return "Fixed Amount Discount: $" + discountAmount;
    }
}
