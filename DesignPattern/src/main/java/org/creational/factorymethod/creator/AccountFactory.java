package org.creational.factorymethod.creator;

import org.creational.factorymethod.products.Account;

/**
 * The AccountFactory abstract class declares the factory method for creating accounts.
 */
public abstract class AccountFactory
{
    /**
     * Factory method for creating an account.
     *
     * @return a new Account object
     */
    public abstract Account createAccount();

    /**
     * Gets an account and displays its type.
     *
     * @return the created Account object
     */
    public Account getAccount()
    {
        Account account = createAccount();
        account.accountType();
        return account;
    }
}
