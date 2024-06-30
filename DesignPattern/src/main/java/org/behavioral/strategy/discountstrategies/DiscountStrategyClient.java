package org.behavioral.strategy.discountstrategies;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiscountStrategyClient
{
    private static final Logger logger = Logger.getLogger(DiscountStrategyClient.class.getName());

    public static void main(String[] args)
    {
        // Setup logger
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);

        Scanner scanner = new Scanner(System.in);


        ShoppingCart cart = new ShoppingCart();

        // Add items to cart
        cart.addItem(new Item("Laptop", 1200.0, 1));
        cart.addItem(new Item("Smartphone", 800.0, 2));
        cart.addItem(new Item("Headphones", 150.0, 3));

        // Select discount strategies
        System.out.println("Select discount methods (comma separated for multiple):");
        System.out.println("1. Percentage Discount");
        System.out.println("2. Fixed Amount Discount");
        System.out.println("3. Buy One Get One Free Discount");

        String[] choices = scanner.nextLine().split(",");
        for (String choice : choices)
        {
            switch (choice.trim())
            {
                case "1":
                    System.out.println("Enter discount percentage:");
                    double percentage = scanner.nextDouble();
                    cart.addDiscountStrategy(new PercentageDiscount(percentage));
                    break;
                case "2":
                    System.out.println("Enter fixed discount amount:");
                    double amount = scanner.nextDouble();
                    cart.addDiscountStrategy(new FixedAmountDiscount(amount));
                    break;
                case "3":
                    cart.addDiscountStrategy(new BuyOneGetOneFreeDiscount());
                    break;
                default:
                    System.out.println("Invalid choice: " + choice);
                    break;
            }
            scanner.nextLine(); // Consume newline
        }

        // Display cart and discounts
        cart.displayItems();
        cart.displayDiscounts();
        cart.checkout();
    }
}
