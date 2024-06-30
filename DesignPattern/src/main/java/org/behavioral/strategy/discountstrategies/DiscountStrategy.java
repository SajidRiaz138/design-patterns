package org.behavioral.strategy.discountstrategies;

import java.util.List;

public interface DiscountStrategy
{
    double applyDiscount(double total, List<Item> items);
}
