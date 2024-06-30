package org.creational.factorymethod;

import org.creational.factorymethod.creator.AccountFactory;
import org.creational.factorymethod.creator.BusinessAccountFactory;
import org.creational.factorymethod.creator.CheckingAccountFactory;
import org.creational.factorymethod.creator.SavingsAccountFactory;
import org.creational.factorymethod.products.Account;

public class FactoryMethodClient
{

    public static void main(String[] args)
    {
        AccountFactory savingAccountFactory = new SavingsAccountFactory();
        Account savings = savingAccountFactory.getAccount();
        savings.deposit(1000);
        savings.withdraw(500);
        System.out.println("Savings Account Balance: " + savings.checkBalance());

        AccountFactory checkingAccountFactory = new CheckingAccountFactory();
        Account checking = checkingAccountFactory.getAccount();
        checking.deposit(2000);
        checking.withdraw(2500);
        System.out.println("Checking Account Balance: " + checking.checkBalance());

        AccountFactory businessAccountFactory = new BusinessAccountFactory();
        Account business = businessAccountFactory.getAccount();
        business.deposit(5000);
        business.withdraw(3000);
        System.out.println("Business Account Balance: " + business.checkBalance());
    }
}
