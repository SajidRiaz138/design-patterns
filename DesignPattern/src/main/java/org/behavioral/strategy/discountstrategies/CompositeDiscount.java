package org.behavioral.strategy.discountstrategies;

import java.util.List;

public class CompositeDiscount implements DiscountStrategy
{
    private List<DiscountStrategy> strategies;

    public CompositeDiscount(List<DiscountStrategy> strategies)
    {
        this.strategies = strategies;
    }

    @Override
    public double applyDiscount(double total, List<Item> items)
    {
        for (DiscountStrategy strategy : strategies)
        {
            total = strategy.applyDiscount(total, items);
        }
        return total;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Composite Discount [");
        for (DiscountStrategy strategy : strategies)
        {
            sb.append(strategy.toString()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
