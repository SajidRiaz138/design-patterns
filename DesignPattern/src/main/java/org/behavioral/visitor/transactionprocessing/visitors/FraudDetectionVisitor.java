package org.behavioral.visitor.transactionprocessing.visitors;

import org.behavioral.visitor.transactionprocessing.elements.DepositTransaction;
import org.behavioral.visitor.transactionprocessing.elements.TransferTransaction;
import org.behavioral.visitor.transactionprocessing.elements.WithdrawalTransaction;

import java.util.ArrayList;
import java.util.List;

public class FraudDetectionVisitor implements TransactionVisitor
{
    private List<String> suspiciousActivities = new ArrayList<>();

    @Override
    public void visit(DepositTransaction transaction)
    {
        if (transaction.getAmount() > 10000)
        {
            suspiciousActivities.add("Suspicious Deposit: $" + transaction.getAmount() + " to account " + transaction.getAccountNumber()
                    + " on " + transaction.getDate());
        }
    }

    @Override
    public void visit(WithdrawalTransaction transaction)
    {
        if (transaction.getAmount() > 10000)
        {
            suspiciousActivities.add("Suspicious Withdrawal: $" + transaction.getAmount() + " from account "
                    + transaction.getAccountNumber() + " on " + transaction.getDate());
        }
    }

    @Override
    public void visit(TransferTransaction transaction)
    {
        if (transaction.getAmount() > 10000)
        {
            suspiciousActivities
                    .add("Suspicious Transfer: $" + transaction.getAmount() + " from account " + transaction.getFromAccountNumber()
                            + " to account " + transaction.getToAccountNumber() + " on " + transaction.getDate());
        }
    }

    public List<String> getSuspiciousActivities()
    {
        return suspiciousActivities;
    }
}
