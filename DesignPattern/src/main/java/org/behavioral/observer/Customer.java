package org.behavioral.observer;

public class Customer
{
    private String name;
    private EmailListener emailListener;
    private PhoneListener phoneListener;

    public Customer(String name, String email, String phoneNumber)
    {
        this.name = name;
        this.emailListener = new EmailListener(email);
        this.phoneListener = new PhoneListener(phoneNumber);
    }

    public void subscribeToNewMovies(NotificationService notificationService)
    {
        notificationService.subscribe(Event.NEW_MOVIE, emailListener);
        notificationService.subscribe(Event.NEW_MOVIE, phoneListener);
    }

    public void subscribeToMovieBackInStock(NotificationService notificationService)
    {
        notificationService.subscribe(Event.MOVIE_BACK_IN_STOCK, emailListener);
        notificationService.subscribe(Event.MOVIE_BACK_IN_STOCK, phoneListener);
    }
}
