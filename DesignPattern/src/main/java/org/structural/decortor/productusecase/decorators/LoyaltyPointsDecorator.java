package org.structural.decortor.productusecase.decorators;

import org.structural.decortor.productusecase.component.Product;

/**
 * The LoyaltyPointsDecorator class adds loyalty points to the product.
 */
public class LoyaltyPointsDecorator extends ProductDecorator
{
    private int points;

    public LoyaltyPointsDecorator(Product decoratedProduct, int points)
    {
        super(decoratedProduct);
        this.points = points;
    }

    @Override
    public double getCost()
    {
        return super.getCost(); // no cost change for adding loyalty points
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " (Loyalty Points: " + points + ")";
    }
}
