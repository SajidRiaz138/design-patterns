package org.creational.abstractfactory.factories;

import org.creational.abstractfactory.products.Beverage;
import org.creational.abstractfactory.products.BreakfastBeverage;
import org.creational.abstractfactory.products.BreakfastDessert;
import org.creational.abstractfactory.products.BreakfastMainCourse;
import org.creational.abstractfactory.products.Dessert;
import org.creational.abstractfactory.products.MainCourse;

public class BreakfastMenuFactory implements MenuFactory
{
    @Override
    public MainCourse createMainCourse()
    {
        return new BreakfastMainCourse();
    }

    @Override
    public Dessert createDessert()
    {
        return new BreakfastDessert();
    }

    @Override
    public Beverage createBeverage()
    {
        return new BreakfastBeverage();
    }
}
