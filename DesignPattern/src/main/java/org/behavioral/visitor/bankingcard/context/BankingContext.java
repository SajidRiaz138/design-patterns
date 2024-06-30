package org.behavioral.visitor.bankingcard.context;

import org.behavioral.visitor.bankingcard.elements.BankingCard;
import org.behavioral.visitor.bankingcard.visitors.BankingCardVisitor;

import java.util.ArrayList;
import java.util.List;

public class BankingContext
{
    private List<BankingCard> cards;

    public BankingContext()
    {
        this.cards = new ArrayList<>();
    }

    public void addCard(BankingCard card)
    {
        cards.add(card);
    }

    public void accept(BankingCardVisitor visitor)
    {
        for (BankingCard card : cards)
        {
            card.accept(visitor);
        }
    }
}
