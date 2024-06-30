package org.behavioral.chain.handlers;

import java.util.HashMap;
import java.util.Map;

/**
 * The PaymentHandlerRegistry class manages the mapping between payment methods and processors.
 */
public class PaymentHandlerRegistry
{
    private Map<String, PaymentHandler> processors = new HashMap<>();

    public void registerHandler(PaymentHandler handler)
    {
        processors.put(handler.getPaymentMethod(), handler);
    }

    public PaymentHandler getHandler(String paymentMethod)
    {
        return processors.get(paymentMethod);
    }
}
