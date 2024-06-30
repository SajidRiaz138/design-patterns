package org.behavioral.visitor.transactionprocessing.elements;

import org.behavioral.visitor.transactionprocessing.visitors.TransactionVisitor;

import java.util.ArrayList;
import java.util.List;

public class FinancialApplication
{
    private List<Transaction> transactions;

    public FinancialApplication()
    {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
    }

    public void processTransactions(TransactionVisitor visitor)
    {
        for (Transaction transaction : transactions)
        {
            transaction.accept(visitor);
        }
    }
}
