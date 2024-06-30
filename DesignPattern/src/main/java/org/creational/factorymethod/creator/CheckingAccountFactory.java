package org.creational.factorymethod.creator;

import org.creational.factorymethod.products.Account;
import org.creational.factorymethod.products.CheckingAccount;

/**
 * The CheckingAccountFactory class is a concrete creator that creates CheckingAccount objects.
 */
public class CheckingAccountFactory extends AccountFactory
{
    @Override
    public Account createAccount()
    {
        return new CheckingAccount();
    }
}
