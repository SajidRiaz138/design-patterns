package org.behavioral.visitor.transactionprocessing.visitors;

import org.behavioral.visitor.transactionprocessing.elements.DepositTransaction;
import org.behavioral.visitor.transactionprocessing.elements.TransferTransaction;
import org.behavioral.visitor.transactionprocessing.elements.WithdrawalTransaction;

import java.util.ArrayList;
import java.util.List;

public class AuditVisitor implements TransactionVisitor
{
    private List<String> auditLogs = new ArrayList<>();

    @Override
    public void visit(DepositTransaction transaction)
    {
        auditLogs.add("Audit Log: Deposit of $" + transaction.getAmount() + " to account " + transaction.getAccountNumber() + " on "
                + transaction.getDate());
    }

    @Override
    public void visit(WithdrawalTransaction transaction)
    {
        auditLogs.add("Audit Log: Withdrawal of $" + transaction.getAmount() + " from account " + transaction.getAccountNumber() + " on "
                + transaction.getDate());
    }

    @Override
    public void visit(TransferTransaction transaction)
    {
        auditLogs.add("Audit Log: Transfer of $" + transaction.getAmount() + " from account " + transaction.getFromAccountNumber()
                + " to account " + transaction.getToAccountNumber() + " on " + transaction.getDate());
    }

    public List<String> getAuditLogs()
    {
        return auditLogs;
    }
}
