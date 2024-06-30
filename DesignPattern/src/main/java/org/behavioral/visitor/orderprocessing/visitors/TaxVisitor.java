package org.behavioral.visitor.orderprocessing.visitors;

import org.behavioral.visitor.orderprocessing.elements.DigitalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.PhysicalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.SubscriptionOrder;

public class TaxVisitor implements OrderVisitor {
    private static final double PHYSICAL_PRODUCT_TAX_RATE = 0.08; // 8%
    private static final double DIGITAL_PRODUCT_TAX_RATE = 0.05; // 5%
    private static final double SUBSCRIPTION_TAX_RATE = 0.12; // 12%

    private double totalTax = 0;

    @Override
    public void visit(PhysicalProductOrder order) {
        totalTax += order.getPrice() * PHYSICAL_PRODUCT_TAX_RATE;
    }

    @Override
    public void visit(DigitalProductOrder order) {
        totalTax += order.getPrice() * DIGITAL_PRODUCT_TAX_RATE;
    }

    @Override
    public void visit(SubscriptionOrder order) {
        totalTax += order.getMonthlyFee() * order.getMonths() * SUBSCRIPTION_TAX_RATE;
    }

    public double getTotalTax() {
        return totalTax;
    }
}
