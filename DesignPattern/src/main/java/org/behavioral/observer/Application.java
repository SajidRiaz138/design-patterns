package org.behavioral.observer;

public class Application
{
    public static void main(String[] args)
    {
        NotificationService notificationService = new NotificationService();
        MovieStore movieStore = new MovieStore(notificationService);

        Customer customer1 = new Customer("Alice", "alice@example.com", "123-456-7890");
        Customer customer2 = new Customer("Bob", "bob@example.com", "098-765-4321");

        customer1.subscribeToNewMovies(notificationService);
        customer1.subscribeToMovieBackInStock(notificationService);

        customer2.subscribeToNewMovies(notificationService);
        customer2.subscribeToMovieBackInStock(notificationService);

        movieStore.addMovie(new Movie("The Matrix", true));
        movieStore.rentMovie("The Matrix");
        movieStore.returnMovie("The Matrix");
    }
}
