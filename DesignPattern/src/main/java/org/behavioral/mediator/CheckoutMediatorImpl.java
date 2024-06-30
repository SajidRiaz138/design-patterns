package org.behavioral.mediator;

import java.util.logging.Logger;

public class CheckoutMediatorImpl implements CheckoutMediator
{
    private static final Logger LOGGER = Logger.getLogger(CheckoutMediatorImpl.class.getName());

    private Cart cart;
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShippingService shippingService;
    private NotificationService notificationService;

    public CheckoutMediatorImpl(Cart cart,
                                InventoryService inventoryService,
                                PaymentService paymentService,
                                ShippingService shippingService,
                                NotificationService notificationService)
    {
        this.cart = cart;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.shippingService = shippingService;
        this.notificationService = notificationService;
    }

    @Override
    public void validateCart()
    {
        if (inventoryService.validate(cart))
        {
            LOGGER.info("Cart validated successfully.");
        }
        else
        {
            LOGGER.warning("Cart validation failed.");
            throw new RuntimeException("Cart validation failed.");
        }
    }

    @Override
    public void processPayment()
    {
        if (cart.isValid() && paymentService.process(cart))
        {
            LOGGER.info("Payment processed successfully.");
        }
        else
        {
            LOGGER.warning("Payment processing failed.");
            throw new RuntimeException("Payment processing failed.");
        }
    }

    @Override
    public void arrangeShipping()
    {
        if (cart.isPaid())
        {
            try
            {
                shippingService.ship(cart);
                LOGGER.info("Shipping arranged successfully.");
            }
            catch (Exception e)
            {
                LOGGER.severe("Shipping arrangement failed: " + e.getMessage());
                throw new RuntimeException("Shipping arrangement failed.", e);
            }
        }
        else
        {
            LOGGER.warning("Shipping failed: Payment not processed.");
            throw new RuntimeException("Shipping failed: Payment not processed.");
        }
    }

    @Override
    public void sendNotifications()
    {
        try
        {
            notificationService.notify(cart);
            LOGGER.info("Notification sent successfully.");
        }
        catch (Exception e)
        {
            LOGGER.severe("Notification sending failed: " + e.getMessage());
            throw new RuntimeException("Notification sending failed.", e);
        }
    }

    @Override
    public void confirmOrder()
    {
        if (cart.isShipped())
        {
            LOGGER.info("Order confirmed successfully.");
            inventoryService.updateInventory(cart);
        }
        else
        {
            LOGGER.warning("Order confirmation failed: Shipping not arranged.");
            throw new RuntimeException("Order confirmation failed: Shipping not arranged.");
        }
    }

    @Override
    public void cancelOrder()
    {
        try
        {
            if (cart.isShipped())
            {
                shippingService.cancelShipping(cart);
            }
            if (cart.isPaid())
            {
                paymentService.refund(cart);
            }
            notificationService.sendCancellation(cart);
            LOGGER.info("Order cancelled successfully.");
        }
        catch (Exception e)
        {
            LOGGER.severe("Order cancellation failed: " + e.getMessage());
            throw new RuntimeException("Order cancellation failed.", e);
        }
    }

    @Override
    public void checkout()
    {
        try
        {
            validateCart();
            processPayment();
            arrangeShipping();
            sendNotifications();
            confirmOrder();
            LOGGER.info("Checkout process completed successfully.");
        }
        catch (Exception e)
        {
            LOGGER.severe("Checkout process failed: " + e.getMessage());
        }
    }
}
