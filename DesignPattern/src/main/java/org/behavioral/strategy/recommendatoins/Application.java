package org.behavioral.strategy.recommendatoins;

import java.util.Arrays;
import java.util.List;

public class Application
{
    public static void main(String[] args)
    {
        // Create users with distinct friends and interests
        User alice = new User("Alice", Arrays.asList(), Arrays.asList("Music", "Travel", "Books"), new UserActivity(10, 5, 15));
        User bob = new User("Bob", Arrays.asList(alice), Arrays.asList("Music", "Sports", "Movies"), new UserActivity(20, 10, 25));
        User charlie = new User("Charlie", Arrays.asList(bob), Arrays.asList("Travel", "Cooking", "Art"), new UserActivity(5, 2, 8));
        User dave =
                new User("Dave", Arrays.asList(bob, charlie), Arrays.asList("Sports", "Technology", "Music"), new UserActivity(15, 7, 12));
        User eve = new User("Eve", Arrays.asList(charlie), Arrays.asList("Books", "Travel", "Music"), new UserActivity(8, 4, 10));

        List<User> allUsers = Arrays.asList(alice, bob, charlie, dave, eve);

        // Create a recommendation context
        RecommendationContext context = new RecommendationContext("Morning", "New York");

        // Create a social network context
        SocialNetwork socialNetwork = new SocialNetwork();

        // Set and use the mutual friends recommendation strategy
        socialNetwork.setRecommendationStrategy(new MutualFriendsRecommendation());
        List<User> recommendedFriends = socialNetwork.recommendFriends(alice, allUsers, context);
        System.out.println("Mutual Friends Recommendation for Alice: " + recommendedFriends);

        // Set and use the interests-based recommendation strategy
        socialNetwork.setRecommendationStrategy(new InterestsBasedRecommendation());
        recommendedFriends = socialNetwork.recommendFriends(alice, allUsers, context);
        System.out.println("Interests-Based Recommendation for Alice: " + recommendedFriends);

        // Set and use the composite recommendation strategy
        socialNetwork.setRecommendationStrategy(
                new CompositeRecommendationStrategy(Arrays.asList(new MutualFriendsRecommendation(), new InterestsBasedRecommendation())));
        recommendedFriends = socialNetwork.recommendFriends(alice, allUsers, context);
        System.out.println("Composite Recommendation for Alice: " + recommendedFriends);
    }
}
