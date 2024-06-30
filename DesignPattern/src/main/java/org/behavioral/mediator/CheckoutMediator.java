package org.behavioral.mediator;

interface CheckoutMediator
{
    void validateCart();

    void processPayment();

    void arrangeShipping();

    void sendNotifications();

    void confirmOrder();

    void cancelOrder();

    void checkout();
}
