package org.creational.factorymethod.creator;

import org.creational.factorymethod.products.Account;
import org.creational.factorymethod.products.BusinessAccount;

/**
 * The BusinessAccountFactory class is a concrete creator that creates BusinessAccount objects.
 */
public class BusinessAccountFactory extends AccountFactory
{
    @Override
    public Account createAccount()
    {
        return new BusinessAccount();
    }
}
