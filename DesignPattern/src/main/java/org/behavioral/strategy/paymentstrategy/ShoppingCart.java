package org.behavioral.strategy.paymentstrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
    private List<String> items;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart()
    {
        items = new ArrayList<>();
    }

    public void addItem(String item)
    {
        items.add(item);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy)
    {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount)
    {
        try
        {
            if (paymentStrategy == null)
            {
                throw new IllegalStateException("Payment strategy not set.");
            }
            paymentStrategy.validateDetails();
            paymentStrategy.pay(amount);
            logTransaction(amount);
        }
        catch (InvalidPaymentException | PaymentException e)
        {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }

    private void logTransaction(double amount)
    {
        System.out.println("Transaction logged: Paid $" + amount);
    }
}
