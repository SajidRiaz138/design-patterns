package org.behavioral.strategy.discountstrategies;

import java.util.List;

public class BuyOneGetOneFreeDiscount implements DiscountStrategy
{
    @Override
    public double applyDiscount(double total, List<Item> items)
    {
        double discount = 0.0;
        for (Item item : items)
        {
            int quantity = item.getQuantity();
            if (quantity >= 2)
            {
                discount += item.getPrice() * (quantity / 2);
            }
        }
        return total - discount;
    }

    @Override
    public String toString()
    {
        return "Buy One Get One Free Discount";
    }
}
