package org.behavioral.visitor.transactionprocessing.visitors;

import org.behavioral.visitor.transactionprocessing.elements.DepositTransaction;
import org.behavioral.visitor.transactionprocessing.elements.TransferTransaction;
import org.behavioral.visitor.transactionprocessing.elements.WithdrawalTransaction;

public interface TransactionVisitor
{
    void visit(DepositTransaction transaction);

    void visit(WithdrawalTransaction transaction);

    void visit(TransferTransaction transaction);
}
