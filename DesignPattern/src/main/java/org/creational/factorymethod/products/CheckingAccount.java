package org.creational.factorymethod.products;

/**
 * The CheckingAccount class represents a checking account.
 */
public class CheckingAccount implements Account
{
    private double balance;
    private double overdraftLimit = 500.0;

    @Override
    public void accountType()
    {
        System.out.println("Checking Account");
    }

    @Override
    public void deposit(double amount)
    {
        balance += amount;
        System.out.println("Deposited " + amount + " into Checking Account");
    }

    @Override
    public void withdraw(double amount)
    {
        if (balance + overdraftLimit >= amount)
        {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Checking Account");
        }
        else
        {
            System.out.println("Overdraft limit exceeded in Checking Account");
        }
    }

    @Override
    public double checkBalance()
    {
        return balance;
    }
}
