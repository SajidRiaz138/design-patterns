package org.behavioral.strategy.recommendatoins;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InterestsBasedRecommendation implements FriendRecommendationStrategy
{
    @Override
    public List<User> recommendFriends(User user, List<User> allUsers, RecommendationContext context)
    {
        return allUsers.stream()
                .filter(u -> !u.equals(user))
                .filter(u -> !user.getFriends().contains(u))
                .sorted((u1, u2) -> Integer.compare(
                        countCommonInterests(user, u2), countCommonInterests(user, u1)))
                .collect(Collectors.toList());
    }

    private int countCommonInterests(User user1, User user2)
    {
        List<String> user1Interests = new ArrayList<>(user1.getInterests());
        List<String> user2Interests = new ArrayList<>(user2.getInterests());
        user1Interests.retainAll(user2Interests);
        int commonInterests = user1Interests.size();
        System.out.println(user1.getName() + " and " + user2.getName() + " have " + commonInterests + " common interests.");
        return commonInterests;
    }

    @Override
    public String toString()
    {
        return "Interests-Based Recommendation";
    }
}
