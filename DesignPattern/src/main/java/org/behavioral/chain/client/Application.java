package org.behavioral.chain.client;

import java.util.logging.Logger;

import org.behavioral.chain.handlers.BankTransferHandler;
import org.behavioral.chain.handlers.CreditCardHandler;
import org.behavioral.chain.handlers.PaymentHandler;
import org.behavioral.chain.handlers.PaymentHandlerRegistry;
import org.behavioral.chain.handlers.PaymentRequest;
import org.behavioral.chain.handlers.PaypalHandler;

public class Application
{
    public static void main(String[] args)
    {
        PaymentHandlerRegistry registry = new PaymentHandlerRegistry();

        // Create payment handlers
        PaymentHandler creditCardHandler = new CreditCardHandler();
        PaymentHandler payPalHandler = new PaypalHandler();
        PaymentHandler bankTransferHandler = new BankTransferHandler();

        // Register handlers
        registry.registerHandler(creditCardHandler);
        registry.registerHandler(payPalHandler);
        registry.registerHandler(bankTransferHandler);

        // Create payment requests
        PaymentRequest request1 = new PaymentRequest(100.0, "credit_card");
        PaymentRequest request2 = new PaymentRequest(200.0, "paypal");
        PaymentRequest request3 = new PaymentRequest(300.0, "bank_transfer");
        PaymentRequest request4 = new PaymentRequest(400.0, "crypto");

        // Process payment requests
        handlePayment(registry, request1);
        handlePayment(registry, request2);
        handlePayment(registry, request3);
        handlePayment(registry, request4);

        // Report metrics using switch with pattern matching
        reportHandlerMetrics(creditCardHandler);
        reportHandlerMetrics(payPalHandler);
        reportHandlerMetrics(bankTransferHandler);
    }

    private static void reportHandlerMetrics(PaymentHandler handler)
    {
        switch (handler)
        {
            case CreditCardHandler p -> p.reportMetrics();
            case PaypalHandler p -> p.reportMetrics();
            case BankTransferHandler p -> p.reportMetrics();
            default ->
                Logger.getLogger(Application.class.getName())
                        .warning("Unknown handler type: " + handler.getClass().getSimpleName());
        }
    }

    private static void handlePayment(PaymentHandlerRegistry registry, PaymentRequest request)
    {
        PaymentHandler handler = registry.getHandler(request.getPaymentMethod());
        if (handler != null)
        {
            handler.handle(request);
        }
        else
        {
            Logger.getLogger(Application.class.getName())
                    .warning("No handler available for payment method: " + request.getPaymentMethod());
        }
    }
}
