package org.behavioral.client;

import org.behavioral.visitor.transactionprocessing.visitors.AuditVisitor;
import org.behavioral.visitor.transactionprocessing.elements.DepositTransaction;
import org.behavioral.visitor.transactionprocessing.elements.FinancialApplication;
import org.behavioral.visitor.transactionprocessing.visitors.FraudDetectionVisitor;
import org.behavioral.visitor.transactionprocessing.visitors.ReportVisitor;
import org.behavioral.visitor.transactionprocessing.elements.TransferTransaction;
import org.behavioral.visitor.transactionprocessing.elements.WithdrawalTransaction;

public class FinancialTransactionClient
{
    public static void main(String[] args)
    {
        FinancialApplication app = new FinancialApplication();

        app.addTransaction(new DepositTransaction(15000, "12345", "2024-06-26"));
        app.addTransaction(new WithdrawalTransaction(5000, "12345", "2024-06-27"));
        app.addTransaction(new TransferTransaction(20000, "12345", "67890", "2024-06-28"));

        AuditVisitor auditVisitor = new AuditVisitor();
        ReportVisitor reportVisitor = new ReportVisitor();
        FraudDetectionVisitor fraudDetectionVisitor = new FraudDetectionVisitor();

        app.processTransactions(auditVisitor);
        app.processTransactions(reportVisitor);
        app.processTransactions(fraudDetectionVisitor);

        System.out.println("Audit Logs:");
        for (String log : auditVisitor.getAuditLogs())
        {
            System.out.println(log);
        }

        System.out.println("\nTotal Deposits: $" + reportVisitor.getTotalDeposits());
        System.out.println("Total Withdrawals: $" + reportVisitor.getTotalWithdrawals());
        System.out.println("Total Transfers: $" + reportVisitor.getTotalTransfers());

        System.out.println("\nSuspicious Activities:");
        for (String activity : fraudDetectionVisitor.getSuspiciousActivities())
        {
            System.out.println(activity);
        }
    }
}
