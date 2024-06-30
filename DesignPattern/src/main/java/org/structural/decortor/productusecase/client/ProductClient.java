package org.structural.decortor.productusecase.client;

import org.structural.decortor.productusecase.component.BaseProduct;
import org.structural.decortor.productusecase.component.Product;
import org.structural.decortor.productusecase.decorators.DiscountDecorator;
import org.structural.decortor.productusecase.decorators.ExpressShippingDecorator;
import org.structural.decortor.productusecase.decorators.GiftWrapDecorator;
import org.structural.decortor.productusecase.decorators.InsuranceDecorator;
import org.structural.decortor.productusecase.decorators.LoyaltyPointsDecorator;
import org.structural.decortor.productusecase.decorators.SeasonalDiscountDecorator;

public class ProductClient
{
    public static void main(String[] args)
    {
        Product basicProduct = new BaseProduct("Smartphone", 500.0, 0.5);
        System.out.println(basicProduct.getDescription() + " $" + basicProduct.getCost());

        Product discountedProduct = new DiscountDecorator(basicProduct, 50.0);
        System.out.println(discountedProduct.getDescription() + " $" + discountedProduct.getCost());

        Product giftWrappedProduct = new GiftWrapDecorator(discountedProduct);
        System.out.println(giftWrappedProduct.getDescription() + " $" + giftWrappedProduct.getCost());

        Product expressShippedProduct = new ExpressShippingDecorator(giftWrappedProduct);
        System.out.println(expressShippedProduct.getDescription() + " $" + expressShippedProduct.getCost());

        Product insuredProduct = new InsuranceDecorator(expressShippedProduct);
        System.out.println(insuredProduct.getDescription() + " $" + insuredProduct.getCost());

        Product seasonalDiscountProduct = new SeasonalDiscountDecorator(insuredProduct, 10.0);
        System.out.println(seasonalDiscountProduct.getDescription() + " $" + seasonalDiscountProduct.getCost());

        Product loyaltyPointsProduct = new LoyaltyPointsDecorator(seasonalDiscountProduct, 100);
        System.out.println(loyaltyPointsProduct.getDescription() + " $" + loyaltyPointsProduct.getCost());
    }
}
