package org.behavioral.strategy.discountstrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ShoppingCart
{
    private static final Logger logger = Logger.getLogger(ShoppingCart.class.getName());
    private List<Item> items;
    private List<DiscountStrategy> discountStrategies;

    public ShoppingCart()
    {
        this.items = new ArrayList<>();
        this.discountStrategies = new ArrayList<>();
    }

    public void addItem(Item item)
    {
        items.add(item);
        logger.info("Added item: " + item);
    }

    public void addDiscountStrategy(DiscountStrategy discountStrategy)
    {
        discountStrategies.add(discountStrategy);
        logger.info("Added discount strategy: " + discountStrategy.getClass().getSimpleName());
    }

    public double calculateTotal()
    {
        double total = 0.0;
        for (Item item : items)
        {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public double applyDiscounts()
    {
        double total = calculateTotal();
        for (DiscountStrategy strategy : discountStrategies)
        {
            total = strategy.applyDiscount(total, items);
        }
        return total;
    }

    public void displayItems()
    {
        System.out.println("Items in cart:");
        for (Item item : items)
        {
            System.out.println(item);
        }
    }

    public void displayDiscounts()
    {
        System.out.println("Applied Discounts:");
        for (DiscountStrategy strategy : discountStrategies)
        {
            System.out.println(strategy);
        }
    }

    public void checkout()
    {
        double total = calculateTotal();
        double discountedTotal = applyDiscounts();

        logger.info("Total amount: $" + total);
        logger.info("Discounted amount: $" + discountedTotal);

        System.out.println("Total amount: $" + total);
        System.out.println("Discounted amount: $" + discountedTotal);
        logTransaction(discountedTotal);
    }

    private void logTransaction(double amount)
    {
        logger.info("Transaction logged: Paid $" + amount);
    }
}
