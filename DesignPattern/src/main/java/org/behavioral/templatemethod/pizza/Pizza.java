package org.behavioral.templatemethod.pizza;

abstract class Pizza
{
    public final void preparePizza()
    {
        try
        {
            preparePizzaBase();
            addSauce();
            addCheese();
            addToppings();
            bakePizza();
            boxPizza();
            System.out.println("Pizza is ready!");
        }
        catch (Exception e)
        {
            System.err.println("Error preparing pizza: " + e.getMessage());
        }
    }

    protected abstract void preparePizzaBase();

    protected abstract void addSauce();

    protected abstract void addCheese();

    protected abstract void addToppings();

    protected abstract void bakePizza();

    protected void boxPizza()
    {
        System.out.println("Placing pizza in the box.");
    }
}
