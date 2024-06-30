package org.behavioral.visitor.transactionprocessing.visitors;

import org.behavioral.visitor.transactionprocessing.elements.DepositTransaction;
import org.behavioral.visitor.transactionprocessing.elements.TransferTransaction;
import org.behavioral.visitor.transactionprocessing.elements.WithdrawalTransaction;

public class ReportVisitor implements TransactionVisitor
{
    private double totalDeposits = 0;
    private double totalWithdrawals = 0;
    private double totalTransfers = 0;

    @Override
    public void visit(DepositTransaction transaction)
    {
        totalDeposits += transaction.getAmount();
    }

    @Override
    public void visit(WithdrawalTransaction transaction)
    {
        totalWithdrawals += transaction.getAmount();
    }

    @Override
    public void visit(TransferTransaction transaction)
    {
        totalTransfers += transaction.getAmount();
    }

    public double getTotalDeposits()
    {
        return totalDeposits;
    }

    public double getTotalWithdrawals()
    {
        return totalWithdrawals;
    }

    public double getTotalTransfers()
    {
        return totalTransfers;
    }
}
