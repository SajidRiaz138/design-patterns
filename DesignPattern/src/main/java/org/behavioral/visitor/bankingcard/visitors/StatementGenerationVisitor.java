package org.behavioral.visitor.bankingcard.visitors;

import org.behavioral.visitor.bankingcard.elements.BusinessCreditCard;
import org.behavioral.visitor.bankingcard.elements.CreditCard;
import org.behavioral.visitor.bankingcard.elements.DebitCard;

import java.util.HashMap;
import java.util.Map;

public class StatementGenerationVisitor implements BankingCardVisitor
{
    private Map<String, String> statements = new HashMap<>();

    @Override
    public void visit(CreditCard creditCard)
    {
        String statement = "Credit Card Statement\n" +
                "Card Number: " + creditCard.getCardNumber() + "\n" +
                "Balance: $" + creditCard.getBalance() + "\n" +
                "Credit Limit: $" + creditCard.getCreditLimit() + "\n" +
                "Interest Rate: " + creditCard.getInterestRate() + "%";
        statements.put(creditCard.getCardNumber(), statement);
    }

    @Override
    public void visit(DebitCard debitCard)
    {
        String statement = "Debit Card Statement\n" +
                "Card Number: " + debitCard.getCardNumber() + "\n" +
                "Balance: $" + debitCard.getBalance();
        statements.put(debitCard.getCardNumber(), statement);
    }

    @Override
    public void visit(BusinessCreditCard businessCreditCard)
    {
        String statement = "Business Credit Card Statement\n" +
                "Card Number: " + businessCreditCard.getCardNumber() + "\n" +
                "Business Name: " + businessCreditCard.getBusinessName() + "\n" +
                "Balance: $" + businessCreditCard.getBalance() + "\n" +
                "Credit Limit: $" + businessCreditCard.getCreditLimit() + "\n" +
                "Interest Rate: " + businessCreditCard.getInterestRate() + "%";
        statements.put(businessCreditCard.getCardNumber(), statement);
    }

    public Map<String, String> getStatements()
    {
        return statements;
    }
}
