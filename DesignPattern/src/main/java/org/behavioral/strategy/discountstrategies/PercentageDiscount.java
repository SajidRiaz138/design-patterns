package org.behavioral.strategy.discountstrategies;

import java.util.List;

public class PercentageDiscount implements DiscountStrategy
{
    private double percentage;

    public PercentageDiscount(double percentage)
    {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double total, List<Item> items)
    {
        return total * (1 - percentage / 100);
    }

    @Override
    public String toString()
    {
        return "Percentage Discount: " + percentage + "%";
    }
}
