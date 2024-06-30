package org.structural.decortor.productusecase.decorators;

import org.structural.decortor.productusecase.component.Product;

/**
 * The DiscountDecorator class applies a discount to the product.
 */
public class DiscountDecorator extends ProductDecorator
{
    private double discount;

    public DiscountDecorator(Product decoratedProduct, double discount)
    {
        super(decoratedProduct);
        this.discount = discount;
    }

    @Override
    public double getCost()
    {
        return super.getCost() - discount; // subtracting the discount from the cost
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " (Discount applied)";
    }
}
