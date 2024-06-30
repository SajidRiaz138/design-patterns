package org.behavioral.templatemethod.pizza;

class VegetablePizza extends Pizza
{
    @Override
    protected void preparePizzaBase()
    {
        System.out.println("Preparing the base for Veg Pizza: Thin crust");
    }

    @Override
    protected void addSauce()
    {
        System.out.println("Adding tomato sauce for Veg Pizza");
    }

    @Override
    protected void addCheese()
    {
        System.out.println("Adding mozzarella cheese for Veg Pizza");
    }

    @Override
    protected void addToppings()
    {
        System.out.println("Adding toppings for Veg Pizza: Olives, Bell Peppers, Onions, Tomatoes");
    }

    @Override
    protected void bakePizza()
    {
        System.out.println("Baking Veg Pizza at 400 degrees for 20 minutes");
    }
}
