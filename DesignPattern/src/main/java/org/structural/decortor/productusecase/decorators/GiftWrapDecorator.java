package org.structural.decortor.productusecase.decorators;

import org.structural.decortor.productusecase.component.Product;

/**
 * The GiftWrapDecorator class adds gift wrapping to the product.
 */
public class GiftWrapDecorator extends ProductDecorator
{
    public GiftWrapDecorator(Product decoratedProduct)
    {
        super(decoratedProduct);
    }

    @Override
    public double getCost()
    {
        return super.getCost() + 5.0; // adding the cost of gift wrapping
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " (Gift Wrapped)";
    }
}
