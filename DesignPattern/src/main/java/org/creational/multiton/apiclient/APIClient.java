package org.creational.multiton.apiclient;

public class APIClient
{
    private final String endpoint;
    private final String apiKey;

    public APIClient(String endpoint, String apiKey)
    {
        this.endpoint = endpoint;
        this.apiKey = apiKey;
    }

    public String getEndpoint()
    {
        return endpoint;
    }

    public String getApiKey()
    {
        return apiKey;
    }

    @Override
    public String toString()
    {
        return "APIClient{" +
                "endpoint='" + endpoint + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }
}
