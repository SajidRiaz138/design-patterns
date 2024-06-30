package org.behavioral.client;

import org.behavioral.iterator.pizamenu.Pizza;
import org.behavioral.iterator.pizamenu.PizzaMenu;

import java.util.Iterator;

public class PizaMenuIteratorClient
{
    public static void main(String[] args)
    {
        PizzaMenu menu = new PizzaMenu();

        menu.addPizza("Margherita", 8.99, "Classic cheese and tomato pizza");
        menu.addPizza("Pepperoni", 10.99, "Pepperoni pizza with cheese");
        menu.addPizza("BBQ Chicken", 12.99, "BBQ sauce with chicken and cheese");
        menu.addPizza("Vegetarian", 9.99, "Pizza with a variety of vegetables");

        System.out.println("Iterating over the Pizza Menu:");
        Iterator<Pizza> iterator = menu.iterator();
        while (iterator.hasNext())
        {
            Pizza pizza = iterator.next();
            System.out.println(pizza);
        }

        System.out.println("\nIterating over the Pizza Menu by price:");
        Iterator<Pizza> priceIterator = menu.priceIterator();
        while (priceIterator.hasNext())
        {
            Pizza pizza = priceIterator.next();
            System.out.println(pizza);
        }
    }
}
