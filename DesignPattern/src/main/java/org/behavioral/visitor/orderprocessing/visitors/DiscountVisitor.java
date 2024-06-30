package org.behavioral.visitor.orderprocessing.visitors;

import org.behavioral.visitor.orderprocessing.elements.DigitalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.PhysicalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.SubscriptionOrder;

public class DiscountVisitor implements OrderVisitor {
    private static final double PHYSICAL_PRODUCT_DISCOUNT = 0.1; // 10%
    private static final double DIGITAL_PRODUCT_DISCOUNT = 0.2; // 20%
    private static final double SUBSCRIPTION_DISCOUNT = 0.15; // 15%

    private double totalDiscount = 0;

    @Override
    public void visit(PhysicalProductOrder order) {
        totalDiscount += order.getPrice() * PHYSICAL_PRODUCT_DISCOUNT;
    }

    @Override
    public void visit(DigitalProductOrder order) {
        totalDiscount += order.getPrice() * DIGITAL_PRODUCT_DISCOUNT;
    }

    @Override
    public void visit(SubscriptionOrder order) {
        totalDiscount += order.getMonthlyFee() * order.getMonths() * SUBSCRIPTION_DISCOUNT;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }
}
