package org.behavioral.strategy.recommendatoins;

public class UserActivity
{
    private int posts;
    private int comments;
    private int likes;

    public UserActivity(int posts, int comments, int likes)
    {
        this.posts = posts;
        this.comments = comments;
        this.likes = likes;
    }

    public int getPosts()
    {
        return posts;
    }

    public int getComments()
    {
        return comments;
    }

    public int getLikes()
    {
        return likes;
    }

    @Override
    public String toString()
    {
        return "UserActivity{posts=" + posts + ", comments=" + comments + ", likes=" + likes + '}';
    }
}
