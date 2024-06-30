package org.structural.decortor.productusecase.decorators;

import org.structural.decortor.productusecase.component.Product;

/**
 * The InsuranceDecorator class adds insurance to the product.
 */
public class InsuranceDecorator extends ProductDecorator
{
    public InsuranceDecorator(Product decoratedProduct)
    {
        super(decoratedProduct);
    }

    @Override
    public double getCost()
    {
        return super.getCost() + 20.0; // adding the cost of insurance
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " (Insurance)";
    }
}
