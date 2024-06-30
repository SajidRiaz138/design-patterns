package org.behavioral.chain.handlers;

import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

/**
 * The AbstractPaymentHandler class provides common processing logic for all payment processors.
 */
public abstract class AbstractPaymentHandler implements PaymentHandler
{
    protected static final Logger logger = Logger.getLogger(AbstractPaymentHandler.class.getName());
    protected Map<String, Integer> metrics = new HashMap<>();

    @Override
    public void handle(PaymentRequest request)
    {
        try
        {
            processPayment(request);
            metrics.put("handled", metrics.getOrDefault("handled", 0) + 1);
        }
        catch (Exception e)
        {
            logger.severe("Error processing payment: " + e.getMessage());
            // Implement retry logic or escalate the error
        }
    }

    protected abstract void processPayment(PaymentRequest request);

    public void reportMetrics()
    {
        logger.info(getClass().getSimpleName() + " Metrics: " + metrics.toString());
    }
}
