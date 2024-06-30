package org.creational.abstractfactory.factories;

import org.creational.abstractfactory.products.Beverage;
import org.creational.abstractfactory.products.Dessert;
import org.creational.abstractfactory.products.MainCourse;

/**
 * The MenuFactory interface declares the factory methods for creating abstract product objects.
 * Implementations of this interface will create menu-specific items.
 */
public interface MenuFactory
{
    MainCourse createMainCourse();

    Dessert createDessert();

    Beverage createBeverage();
}
