package org.behavioral.templatemethod.meal;

abstract class Meal
{
    // Template method
    public final void prepareMeal()
    {
        prepareIngredients();
        cookMainCourse();
        prepareSideDish();
        serveMeal();
        addGarnish();
        if (isTakeaway())
        {
            packMeal();
        }
        System.out.println("Meal is ready!");
    }

    protected abstract void prepareIngredients();

    protected abstract void cookMainCourse();

    protected abstract void prepareSideDish();

    protected abstract void serveMeal();

    protected abstract void addGarnish();

    protected boolean isTakeaway()
    {
        return false; // Default implementation
    }

    protected void packMeal()
    {
        System.out.println("Packing the meal for takeaway.");
    }
}
