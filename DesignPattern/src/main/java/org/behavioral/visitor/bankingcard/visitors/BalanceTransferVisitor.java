package org.behavioral.visitor.bankingcard.visitors;

import org.behavioral.visitor.bankingcard.elements.BusinessCreditCard;
import org.behavioral.visitor.bankingcard.elements.CreditCard;
import org.behavioral.visitor.bankingcard.elements.DebitCard;

public class BalanceTransferVisitor implements BankingCardVisitor
{
    private double amount;
    private String fromCardNumber;
    private String toCardNumber;

    public BalanceTransferVisitor(double amount, String fromCardNumber, String toCardNumber)
    {
        this.amount = amount;
        this.fromCardNumber = fromCardNumber;
        this.toCardNumber = toCardNumber;
    }

    @Override
    public void visit(CreditCard creditCard)
    {
        double balance = creditCard.getBalance();
        if (creditCard.getCardNumber().equals(fromCardNumber))
        {
            balance -= amount;
        }
        else if (creditCard.getCardNumber().equals(toCardNumber))
        {
            balance += amount;
        }
        creditCard.setBalance(balance);
    }

    @Override
    public void visit(DebitCard debitCard)
    {
        double balance = debitCard.getBalance();
        if (debitCard.getCardNumber().equals(fromCardNumber))
        {
            balance -= amount;
        }
        else if (debitCard.getCardNumber().equals(toCardNumber))
        {
            balance += amount;
        }
        debitCard.setBalance(balance);
    }

    @Override
    public void visit(BusinessCreditCard businessCreditCard)
    {
        double balance = businessCreditCard.getBalance();
        if (businessCreditCard.getCardNumber().equals(fromCardNumber))
        {
            balance -= amount;
        }
        else if (businessCreditCard.getCardNumber().equals(toCardNumber))
        {
            balance += amount;
        }
        businessCreditCard.setBalance(balance);
    }
}
