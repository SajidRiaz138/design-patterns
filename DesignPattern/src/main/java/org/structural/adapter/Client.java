package org.structural.adapter;

public class Client
{
    public static void main(String[] args)
    {
        try
        {
            PaymentService paymentService = PaymentServiceFactory.getPaymentService(PaymentServiceType.PAYPAL);
            paymentService.processPayment("123456", 250.0);

            paymentService = PaymentServiceFactory.getPaymentService(PaymentServiceType.STRIPE);
            paymentService.processPayment("34566", 150);

            paymentService = PaymentServiceFactory.getPaymentService(PaymentServiceType.SQUARE);
            paymentService.processPayment("134566", 154);

            paymentService = PaymentServiceFactory.getPaymentService(PaymentServiceType.INTERNAL_BANK_SERVICE);
            paymentService.processPayment("567", 340);

        }
        catch (PaymentException e)
        {
            e.printStackTrace();
        }
    }
}
