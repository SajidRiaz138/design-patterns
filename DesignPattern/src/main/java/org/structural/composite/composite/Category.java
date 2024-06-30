package org.structural.composite.composite;

import org.structural.composite.component.CatalogComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * The Category class represents a composite in the product category hierarchy.
 */
public class Category implements CatalogComponent
{
    private String name;
    private List<CatalogComponent> components = new ArrayList<>();

    public Category(String name)
    {
        this.name = name;
    }

    @Override
    public void showDetails()
    {
        System.out.println("Category: " + name);
        for (CatalogComponent component : components)
        {
            component.showDetails();
        }
    }

    @Override
    public void addComponent(CatalogComponent component)
    {
        components.add(component);
    }

    @Override
    public void removeComponent(CatalogComponent component)
    {
        components.remove(component);
    }

    @Override
    public List<CatalogComponent> getComponents()
    {
        return components;
    }

    @Override
    public double getPrice()
    {
        double totalPrice = 0.0;
        for (CatalogComponent component : components)
        {
            totalPrice += component.getPrice();
        }
        return totalPrice;
    }

    @Override
    public CatalogComponent findByName(String name)
    {
        if (this.name.equals(name))
        {
            return this;
        }
        for (CatalogComponent component : components)
        {
            CatalogComponent found = component.findByName(name);
            if (found != null)
            {
                return found;
            }
        }
        return null;
    }

    @Override
    public int countProducts()
    {
        int totalCount = 0;
        for (CatalogComponent component : components)
        {
            totalCount += component.countProducts();
        }
        return totalCount;
    }

    @Override
    public void updatePrice(String name, double newPrice)
    {
        for (CatalogComponent component : components)
        {
            component.updatePrice(name, newPrice);
        }
    }
}
