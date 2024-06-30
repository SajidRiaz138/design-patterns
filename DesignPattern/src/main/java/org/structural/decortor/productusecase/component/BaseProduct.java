package org.structural.decortor.productusecase.component;

/**
 * The BasicProduct class represents a simple product without any additional features.
 */
public class BaseProduct implements Product
{
    private String name;
    private double price;
    private double weight;

    public BaseProduct(String name, double price, double weight)
    {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public double getCost()
    {
        return price;
    }

    @Override
    public String getDescription()
    {
        return name;
    }

    @Override
    public double getWeight()
    {
        return weight;
    }
}
