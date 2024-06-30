package org.structural.adapter;

/**
 * The PaymentService interface defines the standard interface for payment processing.
 */
public interface PaymentService
{
    /**
     * Processes a payment for the specified account number and amount.
     *
     * @param accountNumber the account number to process the payment for
     * @param amount        the amount to be processed
     * @throws PaymentException if an error occurs during payment processing
     */
    void processPayment(String accountNumber, double amount) throws PaymentException;
}
