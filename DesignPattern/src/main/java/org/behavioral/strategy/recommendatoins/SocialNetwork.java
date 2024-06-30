package org.behavioral.strategy.recommendatoins;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class SocialNetwork
{
    private static final Logger logger = Logger.getLogger(SocialNetwork.class.getName());
    private Optional<FriendRecommendationStrategy> recommendationStrategy = Optional.empty();

    public void setRecommendationStrategy(FriendRecommendationStrategy recommendationStrategy)
    {
        this.recommendationStrategy = Optional.of(recommendationStrategy);
        logger.info("Recommendation strategy set to: " + recommendationStrategy.getClass().getSimpleName());
    }

    public List<User> recommendFriends(User user, List<User> allUsers, RecommendationContext context)
    {
        if (!recommendationStrategy.isPresent())
        {
            throw new IllegalStateException("Recommendation strategy not set.");
        }
        return recommendationStrategy.get().recommendFriends(user, allUsers, context);
    }
}
