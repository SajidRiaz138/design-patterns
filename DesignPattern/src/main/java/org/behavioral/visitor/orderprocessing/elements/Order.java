package org.behavioral.visitor.orderprocessing.elements;

import org.behavioral.visitor.orderprocessing.visitors.OrderVisitor;

public interface Order
{
    void accept(OrderVisitor visitor);
}
