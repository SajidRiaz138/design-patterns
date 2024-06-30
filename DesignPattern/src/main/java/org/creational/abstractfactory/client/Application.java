package org.creational.abstractfactory.client;

import org.creational.abstractfactory.factories.BreakfastMenuFactory;
import org.creational.abstractfactory.factories.DinnerMenuFactory;
import org.creational.abstractfactory.factories.LunchMenuFactory;
import org.creational.abstractfactory.factories.MenuFactory;
import org.creational.abstractfactory.products.Beverage;
import org.creational.abstractfactory.products.Dessert;
import org.creational.abstractfactory.products.MainCourse;

public class Application
{
    public static void main(String[] args)
    {
        MenuFactory breakfastFactory = new BreakfastMenuFactory();
        MainCourse breakfastMainCourse = breakfastFactory.createMainCourse();
        Dessert breakfastDessert = breakfastFactory.createDessert();
        Beverage breakfastBeverage = breakfastFactory.createBeverage();
        breakfastMainCourse.display();
        breakfastDessert.display();
        breakfastBeverage.display();

        MenuFactory lunchFactory = new LunchMenuFactory();
        MainCourse lunchMainCourse = lunchFactory.createMainCourse();
        Dessert lunchDessert = lunchFactory.createDessert();
        Beverage lunchBeverage = lunchFactory.createBeverage();
        lunchMainCourse.display();
        lunchDessert.display();
        lunchBeverage.display();

        MenuFactory dinnerFactory = new DinnerMenuFactory();
        MainCourse dinnerMainCourse = dinnerFactory.createMainCourse();
        Dessert dinnerDessert = dinnerFactory.createDessert();
        Beverage dinnerBeverage = dinnerFactory.createBeverage();
        dinnerMainCourse.display();
        dinnerDessert.display();
        dinnerBeverage.display();
    }
}
