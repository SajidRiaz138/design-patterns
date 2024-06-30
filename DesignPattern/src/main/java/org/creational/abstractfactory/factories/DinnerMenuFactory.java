package org.creational.abstractfactory.factories;

import org.creational.abstractfactory.products.Beverage;
import org.creational.abstractfactory.products.Dessert;
import org.creational.abstractfactory.products.DinnerBeverage;
import org.creational.abstractfactory.products.DinnerDessert;
import org.creational.abstractfactory.products.DinnerMainCourse;
import org.creational.abstractfactory.products.MainCourse;

public class DinnerMenuFactory implements MenuFactory
{
    @Override
    public MainCourse createMainCourse()
    {
        return new DinnerMainCourse();
    }

    @Override
    public Dessert createDessert()
    {
        return new DinnerDessert();
    }

    @Override
    public Beverage createBeverage()
    {
        return new DinnerBeverage();
    }
}
