package org.behavioral.visitor.bankingcard.visitors;

import org.behavioral.visitor.bankingcard.elements.BusinessCreditCard;
import org.behavioral.visitor.bankingcard.elements.CreditCard;
import org.behavioral.visitor.bankingcard.elements.DebitCard;

public interface BankingCardVisitor
{
    void visit(CreditCard creditCard);

    void visit(DebitCard debitCard);

    void visit(BusinessCreditCard businessCreditCard);
}
