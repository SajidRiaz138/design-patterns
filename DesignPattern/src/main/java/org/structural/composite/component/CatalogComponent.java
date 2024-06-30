package org.structural.composite.component;

import java.util.List;

/**
 * The CatalogComponent interface defines operations for products and categories.
 */
public interface CatalogComponent
{
    void showDetails();

    void addComponent(CatalogComponent component);

    void removeComponent(CatalogComponent component);

    List<CatalogComponent> getComponents();

    double getPrice();

    CatalogComponent findByName(String name);

    int countProducts();

    void updatePrice(String name, double newPrice);
}
