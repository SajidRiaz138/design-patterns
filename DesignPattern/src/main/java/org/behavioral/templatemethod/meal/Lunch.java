package org.behavioral.templatemethod.meal;

class Lunch extends Meal
{
    @Override
    protected void prepareIngredients()
    {
        System.out.println("Preparing ingredients for lunch: chicken, rice, vegetables.");
    }

    @Override
    protected void cookMainCourse()
    {
        System.out.println("Cooking main course for lunch: grilled chicken.");
    }

    @Override
    protected void prepareSideDish()
    {
        System.out.println("Preparing side dish for lunch: steamed vegetables.");
    }

    @Override
    protected void serveMeal()
    {
        System.out.println("Serving lunch on the plate.");
    }

    @Override
    protected void addGarnish()
    {
        System.out.println("Adding garnish for lunch: lemon slice.");
    }

    @Override
    protected boolean isTakeaway()
    {
        return true; // Lunch is a takeaway in this example
    }
}
