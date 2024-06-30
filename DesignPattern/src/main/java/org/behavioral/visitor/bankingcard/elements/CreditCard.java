package org.behavioral.visitor.bankingcard.elements;

import org.behavioral.visitor.bankingcard.visitors.BankingCardVisitor;

public class CreditCard implements BankingCard
{
    private String cardNumber;
    private double balance;
    private double creditLimit;
    private double interestRate;

    public CreditCard(String cardNumber, double balance, double creditLimit, double interestRate)
    {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
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

    public double getCreditLimit()
    {
        return creditLimit;
    }

    public double getInterestRate()
    {
        return interestRate;
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
