package org.creational.multiton.currencypairs;

import java.util.EnumMap;
import java.util.Map;

/**
 * ExchangeRateManager class implements the Multiton pattern for managing exchange rates
 * of different currency pairs. This ensures that there is only one instance of the manager
 * for each currency pair.
 */
public class ExchangeRateManager
{
    private static final Map<CurrencyPair, ExchangeRateManager> instances = new EnumMap<>(CurrencyPair.class);
    private final CurrencyPair currencyPair;
    private double exchangeRate;

    private ExchangeRateManager(CurrencyPair currencyPair)
    {
        this.currencyPair = currencyPair;
        this.exchangeRate = loadInitialRate(currencyPair);
    }

    /**
     * Returns the singleton instance of ExchangeRateManager for the given currency pair.
     * If an instance does not already exist, it will be created.
     *
     * @param currencyPair the currency pair for which to get the exchange rate manager.
     * @return the singleton instance of ExchangeRateManager for the given currency pair.
     */
    public static ExchangeRateManager getInstance(CurrencyPair currencyPair)
    {
        return instances.computeIfAbsent(currencyPair, ExchangeRateManager::new);
    }

    /**
     * Loads the initial exchange rate for the given currency pair.
     * In a real application, this would typically load the rate from a database or an external service.
     *
     * @param currencyPair the currency pair for which to load the initial exchange rate.
     * @return the initial exchange rate for the given currency pair.
     */
    private double loadInitialRate(CurrencyPair currencyPair)
    {
        switch (currencyPair)
        {
            case USD_EUR:
                return 0.85;
            case USD_GBP:
                return 0.75;
            case USD_JPY:
                return 110.0;
            case EUR_GBP:
                return 0.88;
            case EUR_JPY:
                return 129.0;
            case GBP_JPY:
                return 146.0;
            default:
                throw new IllegalArgumentException("Unknown currency pair: " + currencyPair);
        }
    }

    /**
     * Returns the current exchange rate for the currency pair.
     *
     * @return the current exchange rate.
     */
    public double getExchangeRate()
    {
        return exchangeRate;
    }

    /**
     * Updates the exchange rate for the currency pair.
     *
     * @param newRate the new exchange rate.
     */
    public void updateExchangeRate(double newRate)
    {
        this.exchangeRate = newRate;
    }

    @Override
    public String toString()
    {
        return "ExchangeRateManager{" +
                "currencyPair=" + currencyPair +
                ", exchangeRate=" + exchangeRate +
                '}';
    }

    public static void main(String[] args)
    {
        ExchangeRateManager usdEurManager = ExchangeRateManager.getInstance(CurrencyPair.USD_EUR);
        System.out.println("USD/EUR Exchange Rate: " + usdEurManager.getExchangeRate());

        ExchangeRateManager usdGbpManager = ExchangeRateManager.getInstance(CurrencyPair.USD_GBP);
        System.out.println("USD/GBP Exchange Rate: " + usdGbpManager.getExchangeRate());

        ExchangeRateManager usdJpyManager = ExchangeRateManager.getInstance(CurrencyPair.USD_JPY);
        System.out.println("USD/JPY Exchange Rate: " + usdJpyManager.getExchangeRate());

        // Update exchange rate for USD/EUR
        usdEurManager.updateExchangeRate(0.86);
        System.out.println("Updated USD/EUR Exchange Rate: " + usdEurManager.getExchangeRate());

        // Verify that the same instance is returned for the same currency pair
        ExchangeRateManager anotherUsdEurManager = ExchangeRateManager.getInstance(CurrencyPair.USD_EUR);
        System.out.println("Another USD/EUR Manager: " + anotherUsdEurManager);
        System.out.println("Is the same instance: " + (usdEurManager == anotherUsdEurManager));
    }
}
