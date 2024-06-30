package org.structural.decortor.productusecase.decorators;

import org.structural.decortor.productusecase.component.Product;

/**
 * The ExpressShippingDecorator class adds express shipping to the product.
 */
public class ExpressShippingDecorator extends ProductDecorator
{
    public ExpressShippingDecorator(Product decoratedProduct)
    {
        super(decoratedProduct);
    }

    @Override
    public double getCost()
    {
        return super.getCost() + 10.0; // adding the cost of express shipping
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " (Express Shipping)";
    }
}
