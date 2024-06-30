package org.behavioral.mediator;

public class PaymentService
{
    public boolean process(Cart cart)
    {
        if (!cart.isValid())
        {
            System.out.println("Payment processing failed: Cart is not valid.");
            return false;
        }
        // Simulate payment processing logic
        System.out.println("Processing payment for items: " + cart.getItems());
        boolean isPaid = true; // Assume payment is successful
        cart.setPaid(isPaid);
        return isPaid;
    }

    public void refund(Cart cart)
    {
        if (cart.isPaid())
        {
            System.out.println("Refunding payment for items: " + cart.getItems());
            cart.setPaid(false);
        }
        else
        {
            System.out.println("Cannot refund: Payment was not processed.");
        }
    }
}
