package org.structural.facade.flightbook.subsystems;

import java.util.HashMap;
import java.util.Map;

/**
 * UserProfileManager manages user profiles for the flight booking system.
 */
public class UserProfileManager
{
    private Map<String, UserProfile> profiles = new HashMap<>();

    /**
     * Adds a new user profile.
     *
     * @param userId         the user ID
     * @param name           the name of the user
     * @param contactDetails the contact details of the user
     */
    public void addUserProfile(String userId, String name, String contactDetails)
    {
        profiles.put(userId, new UserProfile(name, contactDetails));
        System.out.println("Added user profile for user: " + name);
    }

    /**
     * Retrieves a user profile by user ID.
     *
     * @param userId the user ID
     * @return the user profile
     */
    public UserProfile getUserProfile(String userId)
    {
        return profiles.get(userId);
    }

    /**
     * UserProfile represents a user profile with details.
     */
    public record UserProfile(String name, String contactDetails) {
    }
}
