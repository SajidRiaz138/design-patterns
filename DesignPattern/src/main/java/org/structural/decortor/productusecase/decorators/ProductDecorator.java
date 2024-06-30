package org.structural.decortor.productusecase.decorators;

import org.structural.decortor.productusecase.component.Product;

/**
 * The ProductDecorator class implements Product and serves as a base class for all product decorators.
 */
public abstract class ProductDecorator implements Product
{
    protected Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct)
    {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public double getCost()
    {
        return decoratedProduct.getCost();
    }

    @Override
    public String getDescription()
    {
        return decoratedProduct.getDescription();
    }

    @Override
    public double getWeight()
    {
        return decoratedProduct.getWeight();
    }
}
