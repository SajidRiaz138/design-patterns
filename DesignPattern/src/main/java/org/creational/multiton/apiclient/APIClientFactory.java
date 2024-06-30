package org.creational.multiton.apiclient;

public class APIClientFactory
{
    public static APIClient createClient(ServiceType serviceType)
    {
        switch (serviceType)
        {
            case PAYMENT_GATEWAY:
                return new APIClient("https://api.paymentgateway.com", "payment-api-key");
            case NOTIFICATION_SERVICE:
                return new APIClient("https://api.notificationservice.com", "notification-api-key");
            case DATA_PROVIDER:
                return new APIClient("https://api.dataprovider.com", "data-api-key");
            default:
                throw new IllegalArgumentException("Unknown service type: " + serviceType);
        }
    }
}
