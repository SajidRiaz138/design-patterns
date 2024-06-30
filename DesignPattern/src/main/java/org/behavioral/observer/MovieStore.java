package org.behavioral.observer;

import java.util.*;

/**
 * The MovieStore class manages the collection of movies and notifies
 * customers based on events such as new movie arrivals or movies back in stock.
 */
public class MovieStore
{
    private List<Movie> movies;
    private NotificationService notificationService;

    public MovieStore(NotificationService notificationService)
    {
        this.movies = new ArrayList<>();
        this.notificationService = notificationService;
    }

    /**
     * Adds a new movie to the store and notifies subscribers.
     *
     * @param movie The movie to be added.
     */
    public void addMovie(Movie movie)
    {
        movies.add(movie);
        notificationService.notify(Event.NEW_MOVIE, movie.getTitle());
    }

    /**
     * Rents a movie from the store. If the movie is not available, notifies the user.
     *
     * @param title The title of the movie to be rented.
     */
    public void rentMovie(String title)
    {
        for (Movie movie : movies)
        {
            if (movie.getTitle().equals(title) && movie.isInStock())
            {
                movie.setInStock(false);
                System.out.println("Movie rented: " + title);
                return;
            }
        }
        System.out.println("Movie not available: " + title);
    }

    /**
     * Returns a movie to the store and notifies subscribers if the movie was out of stock.
     *
     * @param title The title of the movie to be returned.
     */
    public void returnMovie(String title)
    {
        for (Movie movie : movies)
        {
            if (movie.getTitle().equals(title))
            {
                movie.setInStock(true);
                notificationService.notify(Event.MOVIE_BACK_IN_STOCK, movie.getTitle());
                return;
            }
        }
        System.out.println("Movie not found: " + title);
    }
}
