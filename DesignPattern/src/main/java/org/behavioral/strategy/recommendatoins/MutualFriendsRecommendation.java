package org.behavioral.strategy.recommendatoins;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MutualFriendsRecommendation implements FriendRecommendationStrategy
{
    @Override
    public List<User> recommendFriends(User user, List<User> allUsers, RecommendationContext context)
    {
        return allUsers.stream()
                .filter(u -> !u.equals(user))
                .filter(u -> !user.getFriends().contains(u))
                .filter(u -> countMutualFriends(user, u) > 0) // Exclude users with zero mutual friends
                .sorted((u1, u2) -> Integer.compare(
                        countMutualFriends(user, u2), countMutualFriends(user, u1)))
                .collect(Collectors.toList());
    }

    private int countMutualFriends(User user1, User user2)
    {
        List<User> user1Friends = new ArrayList<>(user1.getFriends());
        List<User> user2Friends = new ArrayList<>(user2.getFriends());
        user1Friends.retainAll(user2Friends);
        int mutualFriends = user1Friends.size();
        System.out.println(user1.getName() + " and " + user2.getName() + " have " + mutualFriends + " mutual friends.");
        return mutualFriends;
    }

    @Override
    public String toString()
    {
        return "Mutual Friends Recommendation";
    }
}
