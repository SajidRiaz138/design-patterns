package org.structural.adapter;

public class PaymentServiceFactory
{
    public static PaymentService getPaymentService(PaymentServiceType paymentServiceType)
    {
        switch (paymentServiceType)
        {
            case PAYPAL:
                return new PayPalPaymentAdapter(new PayPalService());
            case STRIPE:
                return new StripePaymentAdapter(new StripeService());
            case SQUARE:
                return new SquarePaymentAdapter(new SquareService());
            default:
                return new BankPaymentService();
        }
    }
}
