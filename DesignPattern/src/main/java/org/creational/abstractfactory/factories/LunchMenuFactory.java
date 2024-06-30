package org.creational.abstractfactory.factories;

import org.creational.abstractfactory.products.Beverage;
import org.creational.abstractfactory.products.Dessert;
import org.creational.abstractfactory.products.LunchBeverage;
import org.creational.abstractfactory.products.LunchDessert;
import org.creational.abstractfactory.products.LunchMainCourse;
import org.creational.abstractfactory.products.MainCourse;

public class LunchMenuFactory implements MenuFactory
{
    @Override
    public MainCourse createMainCourse()
    {
        return new LunchMainCourse();
    }

    @Override
    public Dessert createDessert()
    {
        return new LunchDessert();
    }

    @Override
    public Beverage createBeverage()
    {
        return new LunchBeverage();
    }
}
