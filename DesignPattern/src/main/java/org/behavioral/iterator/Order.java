package org.behavioral.iterator;

import java.util.Date;
import java.util.Objects;

public class Order
{
    private String orderId;
    private Date date;
    private double amount;

    public Order(String orderId, Date date, double amount)
    {
        this.orderId = orderId;
        this.date = date;
        this.amount = amount;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public Date getDate()
    {
        return date;
    }

    public double getAmount()
    {
        return amount;
    }

    @Override
    public String toString()
    {
        return "Order ID: " + orderId + ", Date: " + date + ", Amount: $" + amount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.amount, amount) == 0 && Objects.equals(orderId, order.orderId) && Objects.equals(date, order.date);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(orderId, date, amount);
    }
}
