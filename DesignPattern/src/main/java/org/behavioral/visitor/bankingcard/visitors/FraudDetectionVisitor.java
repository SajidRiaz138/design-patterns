package org.behavioral.visitor.bankingcard.visitors;

import org.behavioral.visitor.bankingcard.elements.BusinessCreditCard;
import org.behavioral.visitor.bankingcard.elements.CreditCard;
import org.behavioral.visitor.bankingcard.elements.DebitCard;

import java.util.ArrayList;
import java.util.List;

public class FraudDetectionVisitor implements BankingCardVisitor
{
    private List<String> suspiciousCards = new ArrayList<>();

    @Override
    public void visit(CreditCard creditCard)
    {
        if (creditCard.getBalance() > creditCard.getCreditLimit())
        {
            suspiciousCards.add(creditCard.getCardNumber());
            System.out.println("Suspicious activity detected on Credit Card: " + creditCard.getCardNumber());
        }
    }

    @Override
    public void visit(DebitCard debitCard)
    {
        if (debitCard.getBalance() < 0)
        {
            suspiciousCards.add(debitCard.getCardNumber());
            System.out.println("Suspicious activity detected on Debit Card: " + debitCard.getCardNumber());
        }
    }

    @Override
    public void visit(BusinessCreditCard businessCreditCard)
    {
        if (businessCreditCard.getBalance() > businessCreditCard.getCreditLimit())
        {
            suspiciousCards.add(businessCreditCard.getCardNumber());
            System.out.println("Suspicious activity detected on Business Credit Card: " + businessCreditCard.getCardNumber());
        }
    }

    public List<String> getSuspiciousCards()
    {
        return suspiciousCards;
    }
}
