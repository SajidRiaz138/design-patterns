package org.behavioral.visitor.bankingcard.elements;

import org.behavioral.visitor.bankingcard.visitors.BankingCardVisitor;

public class BusinessCreditCard extends CreditCard
{
    private String businessName;

    public BusinessCreditCard(String cardNumber, double balance, double creditLimit, double interestRate, String businessName)
    {
        super(cardNumber, balance, creditLimit, interestRate);
        this.businessName = businessName;
    }

    public String getBusinessName()
    {
        return businessName;
    }

    @Override
    public void accept(BankingCardVisitor visitor)
    {
        visitor.visit(this);
    }
}
