package org.creational.factorymethod.creator;

import org.creational.factorymethod.products.Account;
import org.creational.factorymethod.products.SavingAccount;

/**
 * The SavingAccountFactory class is a concrete creator that creates SavingsAccount objects.
 */
public class SavingsAccountFactory extends AccountFactory
{
    @Override
    public Account createAccount()
    {
        return new SavingAccount();
    }
}
