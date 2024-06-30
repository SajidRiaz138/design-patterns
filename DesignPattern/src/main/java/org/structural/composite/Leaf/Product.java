package org.structural.composite.Leaf;

import org.structural.composite.component.CatalogComponent;

import java.util.Collections;
import java.util.List;

/**
 * The Product class represents a leaf in the product category hierarchy.
 */
public class Product implements CatalogComponent
{
    private String name;
    private double price;

    public Product(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showDetails()
    {
        System.out.println("Product: " + name + ", Price: $" + price);
    }

    @Override
    public void addComponent(CatalogComponent component)
    {
        throw new UnsupportedOperationException("Cannot add component to a product.");
    }

    @Override
    public void removeComponent(CatalogComponent component)
    {
        throw new UnsupportedOperationException("Cannot remove component from a product.");
    }

    @Override
    public List<CatalogComponent> getComponents()
    {
        return Collections.emptyList();
    }

    @Override
    public double getPrice()
    {
        return price;
    }

    @Override
    public CatalogComponent findByName(String name)
    {
        if (this.name.equals(name))
        {
            return this;
        }
        return null;
    }

    @Override
    public int countProducts()
    {
        return 1;
    }

    @Override
    public void updatePrice(String name, double newPrice)
    {
        if (this.name.equals(name))
        {
            this.price = newPrice;
        }
    }
}
