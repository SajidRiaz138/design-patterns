package org.behavioral.templatemethod.meal;

class Dinner extends Meal
{
    @Override
    protected void prepareIngredients()
    {
        System.out.println("Preparing ingredients for dinner: steak, potatoes, salad.");
    }

    @Override
    protected void cookMainCourse()
    {
        System.out.println("Cooking main course for dinner: steak.");
    }

    @Override
    protected void prepareSideDish()
    {
        System.out.println("Preparing side dish for dinner: mashed potatoes.");
    }

    @Override
    protected void serveMeal()
    {
        System.out.println("Serving dinner on the plate.");
    }

    @Override
    protected void addGarnish()
    {
        System.out.println("Adding garnish for dinner: rosemary.");
    }

    @Override
    protected boolean isTakeaway()
    {
        return false; // Dinner is not a takeaway in this example
    }
}
