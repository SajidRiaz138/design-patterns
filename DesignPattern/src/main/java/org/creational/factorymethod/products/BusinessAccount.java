package org.creational.factorymethod.products;

/**
 * The BusinessAccount class represents a business account.
 */
public class BusinessAccount implements Account
{
    private double balance;

    @Override
    public void accountType()
    {
        System.out.println("Business Account");
    }

    @Override
    public void deposit(double amount)
    {
        balance += amount;
        System.out.println("Deposited " + amount + " into Business Account");
    }

    @Override
    public void withdraw(double amount)
    {
        if (balance >= amount)
        {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Business Account");
        }
        else
        {
            System.out.println("Insufficient funds in Business Account");
        }
    }

    @Override
    public double checkBalance()
    {
        return balance;
    }

    /**
     * Provides a business loan for the specified amount.
     *
     * @param amount the loan amount
     */
    public void provideLoan(double amount)
    {
        System.out.println("Provided a loan of " + amount + " to Business Account");
    }
}
