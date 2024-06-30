package org.creational.factorymethod.products;

/**
 * The Account interface represents a bank account with a specific type.
 */
public interface Account
{
    /**
     * Displays the type of account.
     */
    void accountType();

    /**
     * Deposits a specified amount into the account.
     *
     * @param amount the amount to deposit
     */
    void deposit(double amount);

    /**
     * Withdraws a specified amount from the account.
     *
     * @param amount the amount to withdraw
     */
    void withdraw(double amount);

    /**
     * Checks the current balance of the account.
     *
     * @return the current balance
     */
    double checkBalance();
}
