package org.behavioral.strategy.recommendatoins;

import java.util.List;

public interface FriendRecommendationStrategy
{
    List<User> recommendFriends(User user, List<User> allUsers, RecommendationContext context);
}
