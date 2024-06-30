package org.behavioral.templatemethod.meal;

public class Application
{
    public static void main(String[] args)
    {
        Meal breakfast = new Breakfast();
        Meal lunch = new Lunch();
        Meal dinner = new Dinner();

        System.out.println("Preparing breakfast:");
        breakfast.prepareMeal();

        System.out.println("\nPreparing lunch:");
        lunch.prepareMeal();

        System.out.println("\nPreparing dinner:");
        dinner.prepareMeal();
    }
}
