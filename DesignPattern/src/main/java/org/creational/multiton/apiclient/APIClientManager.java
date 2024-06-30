package org.creational.multiton.apiclient;

import java.util.EnumMap;
import java.util.Map;

/**
 * APIClientManager class implements the Multiton pattern for managing
 * API clients for different services. This ensures that there is only
 * one client manager instance for each service type.
 */
public class APIClientManager
{
    private static final Map<ServiceType, APIClientManager> instances = new EnumMap<>(ServiceType.class);
    private final ServiceType serviceType;
    private final APIClient client;

    private APIClientManager(ServiceType serviceType)
    {
        this.serviceType = serviceType;
        this.client = APIClientFactory.createClient(serviceType);
    }

    /**
     * Returns the singleton instance of APIClientManager for the given service type.
     * If an instance does not already exist, it will be created.
     *
     * @param serviceType the service type for which to get the client manager.
     * @return the singleton instance of APIClientManager for the given service type.
     */
    public static APIClientManager getInstance(ServiceType serviceType)
    {
        return instances.computeIfAbsent(serviceType, APIClientManager::new);
    }

    /**
     * Returns the client for the service type.
     *
     * @return the client.
     */
    public APIClient getClient()
    {
        return client;
    }

    @Override
    public String toString()
    {
        return "APIClientManager{" +
                "serviceType=" + serviceType +
                ", client=" + client +
                '}';
    }

    public static void main(String[] args)
    {
        APIClientManager paymentClientManager = APIClientManager.getInstance(ServiceType.PAYMENT_GATEWAY);
        System.out.println("Payment Gateway Client: " + paymentClientManager.getClient());

        APIClientManager notificationClientManager = APIClientManager.getInstance(ServiceType.NOTIFICATION_SERVICE);
        System.out.println("Notification Service Client: " + notificationClientManager.getClient());

        APIClientManager dataProviderClientManager = APIClientManager.getInstance(ServiceType.DATA_PROVIDER);
        System.out.println("Data Provider Client: " + dataProviderClientManager.getClient());

        // Verify that the same instance is returned for the same service type
        APIClientManager anotherPaymentClientManager = APIClientManager.getInstance(ServiceType.PAYMENT_GATEWAY);
        System.out.println("Another Payment Gateway Client: " + anotherPaymentClientManager);
        System.out.println("Is the same instance: " + (paymentClientManager == anotherPaymentClientManager));
    }
}
