package org.behavioral.visitor.transactionprocessing.elements;

import org.behavioral.visitor.transactionprocessing.visitors.TransactionVisitor;

public class TransferTransaction implements Transaction
{
    private double amount;
    private String fromAccountNumber;
    private String toAccountNumber;
    private String date;

    public TransferTransaction(double amount, String fromAccountNumber, String toAccountNumber, String date)
    {
        this.amount = amount;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.date = date;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getFromAccountNumber()
    {
        return fromAccountNumber;
    }

    public String getToAccountNumber()
    {
        return toAccountNumber;
    }

    public String getDate()
    {
        return date;
    }

    @Override
    public void accept(TransactionVisitor visitor)
    {
        visitor.visit(this);
    }
}
