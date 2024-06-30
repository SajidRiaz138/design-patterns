package org.behavioral.strategy.recommendatoins;

public class RecommendationContext
{
    private String timeOfDay;
    private String location;

    public RecommendationContext(String timeOfDay, String location)
    {
        this.timeOfDay = timeOfDay;
        this.location = location;
    }

    public String getTimeOfDay()
    {
        return timeOfDay;
    }

    public String getLocation()
    {
        return location;
    }

    @Override
    public String toString()
    {
        return "RecommendationContext{timeOfDay='" + timeOfDay + '\'' + ", location='" + location + '\'' + '}';
    }
}
