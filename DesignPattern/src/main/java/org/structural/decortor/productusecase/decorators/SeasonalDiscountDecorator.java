package org.structural.decortor.productusecase.decorators;

import org.structural.decortor.productusecase.component.Product;

/**
 * The SeasonalDiscountDecorator class applies a seasonal discount to the product.
 */
public class SeasonalDiscountDecorator extends ProductDecorator
{
    private double discountPercentage;

    public SeasonalDiscountDecorator(Product decoratedProduct, double discountPercentage)
    {
        super(decoratedProduct);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getCost()
    {
        return super.getCost() * (1 - discountPercentage / 100); // applying the seasonal discount
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " (Seasonal Discount)";
    }
}
