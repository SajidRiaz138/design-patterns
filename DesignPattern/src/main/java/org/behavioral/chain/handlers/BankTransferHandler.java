package org.behavioral.chain.handlers;

/**
 * The BankTransferHandler class handles payments made with a bank transfer.
 */
public class BankTransferHandler extends AbstractPaymentHandler
{
    @Override
    public String getPaymentMethod()
    {
        return "bank_transfer";
    }

    @Override
    protected void processPayment(PaymentRequest request)
    {
        logger.info("Processing bank transfer payment of $" + request.getAmount());
        // Perform bank transfer payment processing logic here
    }
}
