package org.behavioral.observer;

public class PhoneListener implements Listener
{
    private String phoneNumber;

    public PhoneListener(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(Event event, String movieTitle)
    {
        System.out.println("Sending SMS to " + phoneNumber + ": Event - " + event + ", Movie - " + movieTitle);
    }
}
