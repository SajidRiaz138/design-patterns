package org.behavioral.visitor.bankingcard.visitors;

import org.behavioral.visitor.bankingcard.elements.BusinessCreditCard;
import org.behavioral.visitor.bankingcard.elements.CreditCard;
import org.behavioral.visitor.bankingcard.elements.DebitCard;

import java.util.HashMap;
import java.util.Map;

public class RewardCalculationVisitor implements BankingCardVisitor
{
    private Map<String, Double> rewards = new HashMap<>();

    @Override
    public void visit(CreditCard creditCard)
    {
        double rewardPoints = creditCard.getBalance() * 0.01; // 1% reward
        rewards.put(creditCard.getCardNumber(), rewardPoints);
    }

    @Override
    public void visit(DebitCard debitCard)
    {
        double rewardPoints = debitCard.getBalance() * 0.005; // 0.5% reward
        rewards.put(debitCard.getCardNumber(), rewardPoints);
    }

    @Override
    public void visit(BusinessCreditCard businessCreditCard)
    {
        double rewardPoints = businessCreditCard.getBalance() * 0.015; // 1.5% reward
        rewards.put(businessCreditCard.getCardNumber(), rewardPoints);
    }

    public Map<String, Double> getRewards()
    {
        return rewards;
    }
}
