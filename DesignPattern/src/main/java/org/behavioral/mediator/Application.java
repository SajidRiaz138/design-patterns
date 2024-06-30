package org.behavioral.mediator;

import java.util.Arrays;

public class Application
{
    public static void main(String[] args)
    {
        Cart cart = new Cart(Arrays.asList("Laptop", "Mouse", "Keyboard"));

        InventoryService inventoryService = new InventoryService();
        PaymentService paymentService = new PaymentService();
        ShippingService shippingService = new ShippingService();
        NotificationService notificationService = new NotificationService();

        CheckoutMediator mediator = new CheckoutMediatorImpl(cart, inventoryService, paymentService, shippingService, notificationService);

        mediator.checkout();

        // Example of canceling an order
        System.out.println("\nCancelling the order:");
        mediator.cancelOrder();
    }
}
