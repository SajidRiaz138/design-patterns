package org.behavioral.visitor.orderprocessing.elements;

import org.behavioral.visitor.orderprocessing.visitors.OrderVisitor;

public class PhysicalProductOrder implements Order
{
    private double price;
    private double weight; // Weight in kg for shipping cost calculation
    private String shippingAddress;

    public PhysicalProductOrder(double price, double weight, String shippingAddress)
    {
        this.price = price;
        this.weight = weight;
        this.shippingAddress = shippingAddress;
    }

    public double getPrice()
    {
        return price;
    }

    public double getWeight()
    {
        return weight;
    }

    public String getShippingAddress()
    {
        return shippingAddress;
    }

    @Override
    public void accept(OrderVisitor visitor)
    {
        visitor.visit(this);
    }
}
