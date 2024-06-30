package org.behavioral.visitor.orderprocessing.elements;

import org.behavioral.visitor.orderprocessing.visitors.OrderVisitor;

public class DigitalProductOrder implements Order
{
    private double price;
    private String downloadLink;

    public DigitalProductOrder(double price, String downloadLink)
    {
        this.price = price;
        this.downloadLink = downloadLink;
    }

    public double getPrice()
    {
        return price;
    }

    public String getDownloadLink()
    {
        return downloadLink;
    }

    @Override
    public void accept(OrderVisitor visitor)
    {
        visitor.visit(this);
    }
}
