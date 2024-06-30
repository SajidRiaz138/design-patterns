package org.behavioral.mediator;

public class ShippingService
{
    public void ship(Cart cart)
    {
        if (!cart.isPaid())
        {
            System.out.println("Shipping failed: Payment not processed.");
            return;
        }
        // Simulate shipping logic
        System.out.println("Arranging shipping for items: " + cart.getItems());
        cart.setShipped(true);
    }

    public void cancelShipping(Cart cart)
    {
        if (cart.isShipped())
        {
            System.out.println("Canceling shipping for items: " + cart.getItems());
            cart.setShipped(false);
        }
        else
        {
            System.out.println("Cannot cancel shipping: Shipping was not arranged.");
        }
    }
}
