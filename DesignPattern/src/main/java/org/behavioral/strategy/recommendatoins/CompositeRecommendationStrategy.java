package org.behavioral.strategy.recommendatoins;

import java.util.List;
import java.util.stream.Collectors;

public class CompositeRecommendationStrategy implements FriendRecommendationStrategy
{
    private List<FriendRecommendationStrategy> strategies;

    public CompositeRecommendationStrategy(List<FriendRecommendationStrategy> strategies)
    {
        this.strategies = strategies;
    }

    @Override
    public List<User> recommendFriends(User user, List<User> allUsers, RecommendationContext context)
    {
        return strategies.stream()
                .flatMap(strategy -> strategy.recommendFriends(user, allUsers, context).stream())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public String toString()
    {
        return "Composite Recommendation Strategy";
    }
}
