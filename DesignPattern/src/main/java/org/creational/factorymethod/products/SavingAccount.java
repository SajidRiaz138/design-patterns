package org.creational.factorymethod.products;

/**
 * The SavingsAccount class represents a savings account.
 */
public class SavingAccount implements Account
{
    private double balance;
    private double interestRate = 0.02; // 2% annual interest rate

    @Override
    public void accountType()
    {
        System.out.println("Savings Account");
    }

    @Override
    public void deposit(double amount)
    {
        balance += amount;
        System.out.println("Deposited " + amount + " into Savings Account");
    }

    @Override
    public void withdraw(double amount)
    {
        if (balance >= amount)
        {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Savings Account");
        }
        else
        {
            System.out.println("Insufficient funds in Savings Account");
        }
    }

    @Override
    public double checkBalance()
    {
        return balance;
    }

    /**
     * Calculates the interest earned over a specified number of years.
     *
     * @param years the number of years
     * @return the interest earned
     */
    public double calculateInterest(int years)
    {
        return balance * Math.pow(1 + interestRate, years) - balance;
    }
}
