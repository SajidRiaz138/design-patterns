package org.behavioral.iterator.pizamenu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PizzaMenu implements Iterable<Pizza>
{
    private List<Pizza> pizzas;

    public PizzaMenu()
    {
        pizzas = new ArrayList<>();
    }

    public void addPizza(String name, double price, String description)
    {
        pizzas.add(new Pizza(name, price, description));
    }

    public List<Pizza> getPizzas()
    {
        return pizzas;
    }

    @Override
    public Iterator<Pizza> iterator()
    {
        return pizzas.iterator();
    }

    public Iterator<Pizza> priceIterator()
    {
        List<Pizza> sortedPizzas = new ArrayList<>(pizzas);
        sortedPizzas.sort(Comparator.comparingDouble(Pizza::getPrice));
        return sortedPizzas.iterator();
    }
}
