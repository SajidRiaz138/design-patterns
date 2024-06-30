package org.behavioral.strategy.paymentstrategy;

public class BankTransferPayment implements PaymentStrategy
{
    private String accountNumber;
    private String bankCode;

    public BankTransferPayment(String accountNumber, String bankCode)
    {
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
    }

    @Override
    public void validateDetails() throws InvalidPaymentException
    {
        if (accountNumber == null || accountNumber.length() < 10)
        {
            throw new InvalidPaymentException("Invalid account number.");
        }
        if (bankCode == null || bankCode.length() != 4)
        {
            throw new InvalidPaymentException("Invalid bank code.");
        }
    }

    @Override
    public void pay(double amount) throws PaymentException
    {
        // Simulate payment processing
        System.out.println("Processing bank transfer payment...");
        if (amount > 5000)
        { // Simulate a payment failure for amounts > 5000
            throw new PaymentException("Bank transfer payment failed due to limit exceeded.");
        }
        System.out.println("Paid $" + amount + " using Bank Transfer.");
    }
}
