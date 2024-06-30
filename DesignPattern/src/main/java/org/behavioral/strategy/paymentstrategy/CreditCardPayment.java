package org.behavioral.strategy.paymentstrategy;

public class CreditCardPayment implements PaymentStrategy
{
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expirationDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expirationDate)
    {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public void validateDetails() throws InvalidPaymentException
    {
        if (cardNumber == null || cardNumber.length() != 16)
        {
            throw new InvalidPaymentException("Invalid credit card number.");
        }
        if (cvv == null || cvv.length() != 3)
        {
            throw new InvalidPaymentException("Invalid CVV.");
        }
        // Add more validation if needed
    }

    @Override
    public void pay(double amount) throws PaymentException
    {
        // Simulate payment processing
        System.out.println("Processing credit card payment...");
        if (amount > 1000)
        { // Simulate a payment failure for amounts > 1000
            throw new PaymentException("Credit card payment failed due to limit exceeded.");
        }
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}
