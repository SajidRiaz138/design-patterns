package org.behavioral.visitor.bankingcard.elements;

import org.behavioral.visitor.bankingcard.visitors.BankingCardVisitor;

public interface BankingCard
{
    void accept(BankingCardVisitor visitor);

    String getCardNumber();
}
