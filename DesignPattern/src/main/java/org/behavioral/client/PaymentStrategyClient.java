package org.behavioral.client;

import org.behavioral.strategy.paymentstrategy.BankTransferPayment;
import org.behavioral.strategy.paymentstrategy.CreditCardPayment;
import org.behavioral.strategy.paymentstrategy.PayPalPayment;
import org.behavioral.strategy.paymentstrategy.ShoppingCart;

import java.util.Scanner;

public class PaymentStrategyClient
{
    public static void main(String[] args)
    {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop");
        cart.addItem("Smartphone");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Bank Transfer");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                System.out.println("Enter Credit Card Number:");
                String cardNumber = scanner.nextLine();
                System.out.println("Enter Card Holder Name:");
                String cardHolderName = scanner.nextLine();
                System.out.println("Enter CVV:");
                String cvv = scanner.nextLine();
                System.out.println("Enter Expiration Date (MM/YY):");
                String expirationDate = scanner.nextLine();
                cart.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolderName, cvv, expirationDate));
                break;
            case 2:
                System.out.println("Enter PayPal Email:");
                String email = scanner.nextLine();
                System.out.println("Enter PayPal Password:");
                String password = scanner.nextLine();
                cart.setPaymentStrategy(new PayPalPayment(email, password));
                break;
            case 3:
                System.out.println("Enter Bank Account Number:");
                String accountNumber = scanner.nextLine();
                System.out.println("Enter Bank Code:");
                String bankCode = scanner.nextLine();
                cart.setPaymentStrategy(new BankTransferPayment(accountNumber, bankCode));
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("Enter the amount to pay:");
        double amount = scanner.nextDouble();
        cart.checkout(amount);
    }
}
