package org.behavioral.client;

import org.behavioral.visitor.bankingcard.context.BankingContext;
import org.behavioral.visitor.bankingcard.elements.BusinessCreditCard;
import org.behavioral.visitor.bankingcard.elements.CreditCard;
import org.behavioral.visitor.bankingcard.elements.DebitCard;
import org.behavioral.visitor.bankingcard.visitors.BalanceTransferVisitor;
import org.behavioral.visitor.bankingcard.visitors.FraudDetectionVisitor;
import org.behavioral.visitor.bankingcard.visitors.InterestCalculationVisitor;
import org.behavioral.visitor.bankingcard.visitors.RewardCalculationVisitor;
import org.behavioral.visitor.bankingcard.visitors.StatementGenerationVisitor;

import java.util.Map;

public class BankingCardClient
{
    public static void main(String[] args)
    {
        BankingContext platform = new BankingContext();

        CreditCard creditCard1 = new CreditCard("1234-5678-9012-3456", 1200.0, 1000.0, 15.0);
        DebitCard debitCard1 = new DebitCard("2345-6789-0123-4567", 500.0);
        BusinessCreditCard businessCreditCard1 = new BusinessCreditCard("4567-8901-2345-6789", 1500.0, 2000.0, 18.0, "TechCorp");

        platform.addCard(creditCard1);
        platform.addCard(debitCard1);
        platform.addCard(businessCreditCard1);

        FraudDetectionVisitor fraudDetectionVisitor = new FraudDetectionVisitor();
        RewardCalculationVisitor rewardCalculationVisitor = new RewardCalculationVisitor();
        StatementGenerationVisitor statementGenerationVisitor = new StatementGenerationVisitor();
        BalanceTransferVisitor balanceTransferVisitor = new BalanceTransferVisitor(200.0, "1234-5678-9012-3456", "2345-6789-0123-4567");
        InterestCalculationVisitor interestCalculationVisitor = new InterestCalculationVisitor();

        System.out.println("Fraud Detection:");
        platform.accept(fraudDetectionVisitor);

        System.out.println("\nReward Calculation:");
        platform.accept(rewardCalculationVisitor);
        for (Map.Entry<String, Double> entry : rewardCalculationVisitor.getRewards().entrySet())
        {
            System.out.println("Card Number: " + entry.getKey() + ", Reward Points: " + entry.getValue());
        }

        System.out.println("\nStatement Generation:");
        platform.accept(statementGenerationVisitor);
        for (Map.Entry<String, String> entry : statementGenerationVisitor.getStatements().entrySet())
        {
            System.out.println(entry.getValue());
        }

        System.out.println("\nBalance Transfer:");
        platform.accept(balanceTransferVisitor);
        platform.accept(statementGenerationVisitor);
        for (Map.Entry<String, String> entry : statementGenerationVisitor.getStatements().entrySet())
        {
            System.out.println(entry.getValue());
        }

        System.out.println("\nInterest Calculation:");
        platform.accept(interestCalculationVisitor);
        for (Map.Entry<String, Double> entry : interestCalculationVisitor.getInterestCharges().entrySet())
        {
            System.out.println("Card Number: " + entry.getKey() + ", Interest Charge: " + entry.getValue());
        }
    }
}
