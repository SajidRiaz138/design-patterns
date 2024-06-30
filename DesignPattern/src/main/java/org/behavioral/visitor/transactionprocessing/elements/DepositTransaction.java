package org.behavioral.visitor.transactionprocessing.elements;

import org.behavioral.visitor.transactionprocessing.visitors.TransactionVisitor;

public class DepositTransaction implements Transaction
{
    private double amount;
    private String accountNumber;
    private String date;

    public DepositTransaction(double amount, String accountNumber, String date)
    {
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.date = date;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getAccountNumber()
    {
        return accountNumber;
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
