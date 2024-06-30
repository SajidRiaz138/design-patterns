package org.behavioral.templatemethod.meal;

class Breakfast extends Meal
{
    @Override
    protected void prepareIngredients()
    {
        System.out.println("Preparing ingredients for breakfast: eggs, bread, butter, fruits.");
    }

    @Override
    protected void cookMainCourse()
    {
        System.out.println("Cooking main course for breakfast: scrambled eggs.");
    }

    @Override
    protected void prepareSideDish()
    {
        System.out.println("Preparing side dish for breakfast: toast with butter.");
    }

    @Override
    protected void serveMeal()
    {
        System.out.println("Serving breakfast on the plate.");
    }

    @Override
    protected void addGarnish()
    {
        System.out.println("Adding garnish for breakfast: parsley.");
    }

    @Override
    protected boolean isTakeaway()
    {
        return false; // Breakfast is usually not a takeaway in this example
    }
}
