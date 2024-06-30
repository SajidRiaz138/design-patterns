package org.behavioral.visitor.orderprocessing.visitors;

import org.behavioral.visitor.orderprocessing.elements.DigitalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.PhysicalProductOrder;
import org.behavioral.visitor.orderprocessing.elements.SubscriptionOrder;

public interface OrderVisitor
{
    void visit(PhysicalProductOrder order);

    void visit(DigitalProductOrder order);

    void visit(SubscriptionOrder order);
}
