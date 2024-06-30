package org.behavioral.client;

import org.behavioral.visitor.orderprocessing.elements.DigitalProductOrder;
import org.behavioral.visitor.orderprocessing.visitors.DiscountVisitor;
import org.behavioral.visitor.orderprocessing.elements.ECommercePlatform;
import org.behavioral.visitor.orderprocessing.visitors.OrderSummaryVisitor;
import org.behavioral.visitor.orderprocessing.visitors.OrderValidationVisitor;
import org.behavioral.visitor.orderprocessing.elements.PhysicalProductOrder;
import org.behavioral.visitor.orderprocessing.visitors.PricingVisitor;
import org.behavioral.visitor.orderprocessing.visitors.ShippingCostVisitor;
import org.behavioral.visitor.orderprocessing.elements.SubscriptionOrder;
import org.behavioral.visitor.orderprocessing.visitors.TaxVisitor;

public class OrderCalculationClient
{
    public static void main(String[] args)
    {
        ECommercePlatform platform = new ECommercePlatform();

        platform.addOrder(new PhysicalProductOrder(100, 2, "Sweden 37134"));
        platform.addOrder(new DigitalProductOrder(50, "https://amazon.org"));
        platform.addOrder(new SubscriptionOrder(10, 12));

        PricingVisitor pricingVisitor = new PricingVisitor();
        ShippingCostVisitor shippingCostVisitor = new ShippingCostVisitor();
        OrderValidationVisitor validationVisitor = new OrderValidationVisitor();
        DiscountVisitor discountVisitor = new DiscountVisitor();
        TaxVisitor taxVisitor = new TaxVisitor();
        OrderSummaryVisitor summaryVisitor = new OrderSummaryVisitor();

        platform.processOrders(pricingVisitor);
        platform.processOrders(shippingCostVisitor);
        platform.processOrders(validationVisitor);
        platform.processOrders(discountVisitor);
        platform.processOrders(taxVisitor);
        platform.processOrders(summaryVisitor);

        System.out.println("Total Price: $" + pricingVisitor.getTotalPrice());
        System.out.println("Total Shipping Cost: $" + shippingCostVisitor.getTotalShippingCost());
        System.out.println("All Orders Valid: " + validationVisitor.isAllValid());
        System.out.println("Total Discount: $" + discountVisitor.getTotalDiscount());
        System.out.println("Total Tax: $" + taxVisitor.getTotalTax());
        System.out.println("Order Summary:\n" + summaryVisitor.getSummary());
    }
}
