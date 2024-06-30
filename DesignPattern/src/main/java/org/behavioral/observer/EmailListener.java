package org.behavioral.observer;

public class EmailListener implements Listener
{
    private String email;
    public EmailListener(String email)
    {
        this.email = email;
    }

    @Override
    public void update(Event event, String movieTitle)
    {
        System.out.println("Sending email to " + email + ": Event - " + event + ", Movie - " + movieTitle);
    }
}
