package org.behavioral.templatemethod.pizza;

public class Application
{
    public static void main(String[] args)
    {
        Pizza vegPizza = new VegetablePizza();
        Pizza chickenPizza = new ChickenPizza();

        System.out.println("Preparing Veg Pizza:");
        vegPizza.preparePizza();

        System.out.println("\nPreparing Chicken Pizza:");
        chickenPizza.preparePizza();
    }
}
