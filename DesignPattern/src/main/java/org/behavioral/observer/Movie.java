package org.behavioral.observer;

public class Movie
{
    private String title;
    private boolean inStock;

    public Movie(String title, boolean inStock)
    {
        this.title = title;
        this.inStock = inStock;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean isInStock()
    {
        return inStock;
    }

    public void setInStock(boolean inStock)
    {
        this.inStock = inStock;
    }
}
