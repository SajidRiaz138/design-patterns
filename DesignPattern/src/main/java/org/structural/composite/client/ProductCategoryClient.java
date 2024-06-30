package org.structural.composite.client;

import org.structural.composite.Leaf.Product;
import org.structural.composite.component.CatalogComponent;
import org.structural.composite.composite.Category;

public class ProductCategoryClient
{
    public static void main(String[] args)
    {
        CatalogComponent laptop = new Product("Laptop", 1000.0);
        CatalogComponent smartphone = new Product("Smartphone", 700.0);
        CatalogComponent tablet = new Product("Tablet", 300.0);

        CatalogComponent electronicsCategory = new Category("Electronics");
        CatalogComponent computersCategory = new Category("Computers");
        CatalogComponent mobilesCategory = new Category("Mobiles");

        computersCategory.addComponent(laptop);
        mobilesCategory.addComponent(smartphone);
        mobilesCategory.addComponent(tablet);

        electronicsCategory.addComponent(computersCategory);
        electronicsCategory.addComponent(mobilesCategory);

        System.out.println("Showing details of Electronics category:");
        electronicsCategory.showDetails();

        System.out.println("\nTotal price of Electronics category: $" + electronicsCategory.getPrice());

        System.out.println("\nFinding Smartphone:");
        CatalogComponent found = electronicsCategory.findByName("Smartphone");
        if (found != null)
        {
            found.showDetails();
        }

        System.out.println("\nTotal number of products in Electronics category: " + electronicsCategory.countProducts());

        System.out.println("\nUpdating price of Smartphone to $750:");
        electronicsCategory.updatePrice("Smartphone", 750.0);
        electronicsCategory.showDetails();
    }
}
