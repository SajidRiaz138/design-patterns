package org.behavioral.strategy.paymentstrategy;

public class PayPalPayment implements PaymentStrategy
{
    private String email;
    private String password;

    public PayPalPayment(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    @Override
    public void validateDetails() throws InvalidPaymentException
    {
        if (email == null || !email.contains("@"))
        {
            throw new InvalidPaymentException("Invalid email address.");
        }
        if (password == null || password.length() < 6)
        {
            throw new InvalidPaymentException("Password must be at least 6 characters long.");
        }
    }

    @Override
    public void pay(double amount) throws PaymentException
    {
        // Simulate payment processing
        System.out.println("Processing PayPal payment...");
        if (amount > 2000)
        { // Simulate a payment failure for amounts > 2000
            throw new PaymentException("PayPal payment failed due to limit exceeded.");
        }
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}
