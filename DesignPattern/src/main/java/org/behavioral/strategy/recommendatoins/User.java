package org.behavioral.strategy.recommendatoins;

import java.util.List;
import java.util.Objects;

public class User
{
    private String name;
    private List<User> friends;
    private List<String> interests;
    private UserActivity activity;

    public User(String name, List<User> friends, List<String> interests, UserActivity activity)
    {
        this.name = name;
        this.friends = friends;
        this.interests = interests;
        this.activity = activity;
    }

    public String getName()
    {
        return name;
    }

    public List<User> getFriends()
    {
        return friends;
    }

    public List<String> getInterests()
    {
        return interests;
    }

    public UserActivity getActivity()
    {
        return activity;
    }

    @Override
    public String toString()
    {
        return "User{name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}
