package org.behavioral.visitor.bankingcard.visitors;

import org.behavioral.visitor.bankingcard.elements.BusinessCreditCard;
import org.behavioral.visitor.bankingcard.elements.CreditCard;
import org.behavioral.visitor.bankingcard.elements.DebitCard;

import java.util.HashMap;
import java.util.Map;

public class InterestCalculationVisitor implements BankingCardVisitor
{
    private Map<String, Double> interestCharges = new HashMap<>();

    @Override
    public void visit(CreditCard creditCard)
    {
        double interest = creditCard.getBalance() * (creditCard.getInterestRate() / 100);
        interestCharges.put(creditCard.getCardNumber(), interest);
    }

    @Override
    public void visit(DebitCard debitCard)
    {
        // No interest calculation for debit cards
    }

    @Override
    public void visit(BusinessCreditCard businessCreditCard)
    {
        double interest = businessCreditCard.getBalance() * (businessCreditCard.getInterestRate() / 100);
        interestCharges.put(businessCreditCard.getCardNumber(), interest);
    }

    public Map<String, Double> getInterestCharges()
    {
        return interestCharges;
    }
}
