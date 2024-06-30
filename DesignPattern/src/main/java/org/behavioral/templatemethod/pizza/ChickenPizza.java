package org.behavioral.templatemethod.pizza;

class ChickenPizza extends Pizza
{
    @Override
    protected void preparePizzaBase()
    {
        System.out.println("Preparing the base for Chicken Pizza: Thick crust");
    }

    @Override
    protected void addSauce()
    {
        System.out.println("Adding BBQ sauce for Chicken Pizza");
    }

    @Override
    protected void addCheese()
    {
        System.out.println("Adding cheddar cheese for Chicken Pizza");
    }

    @Override
    protected void addToppings()
    {
        System.out.println("Adding toppings for Chicken Pizza: Grilled Chicken, Jalapenos, Red Onions");
    }

    @Override
    protected void bakePizza()
    {
        System.out.println("Baking Chicken Pizza at 425 degrees for 25 minutes");
    }
}
