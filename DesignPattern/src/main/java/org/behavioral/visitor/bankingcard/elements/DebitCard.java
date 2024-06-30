package org.behavioral.visitor.bankingcard.elements;

import org.behavioral.visitor.bankingcard.visitors.BankingCardVisitor;

public class DebitCard implements BankingCard
{
    private String cardNumber;
    private double balance;

    public DebitCard(String cardNumber, double balance)
    {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    @Override
    public String getCardNumber()
    {
        return cardNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    @Override
    public void accept(BankingCardVisitor visitor)
    {
        visitor.visit(this);
    }
}
