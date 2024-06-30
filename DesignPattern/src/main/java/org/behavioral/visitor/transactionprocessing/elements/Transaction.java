package org.behavioral.visitor.transactionprocessing.elements;

import org.behavioral.visitor.transactionprocessing.visitors.TransactionVisitor;

public interface Transaction
{
    void accept(TransactionVisitor visitor);
}
