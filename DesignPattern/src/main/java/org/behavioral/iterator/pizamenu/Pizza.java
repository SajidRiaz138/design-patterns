package org.behavioral.iterator.pizamenu;

public class Pizza
{
    private String name;
    private double price;
    private String description;

    public Pizza(String name, double price, String description)
    {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString()
    {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
