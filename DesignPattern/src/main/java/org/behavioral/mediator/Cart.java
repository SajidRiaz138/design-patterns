package org.behavioral.mediator;

import java.util.Collections;
import java.util.List;

class Cart
{
    private List<String> items;
    private boolean isValid;
    private boolean isPaid;
    private boolean isShipped;

    public Cart(List<String> items)
    {
        this.items = items;
        this.isValid = false;
        this.isPaid = false;
        this.isShipped = false;
    }

    public List<String> getItems()
    {
        return Collections.unmodifiableList(items);
    }

    public boolean isValid()
    {
        return isValid;
    }

    public void setValid(boolean isValid)
    {
        this.isValid = isValid;
    }

    public boolean isPaid()
    {
        return isPaid;
    }

    public void setPaid(boolean isPaid)
    {
        this.isPaid = isPaid;
    }

    public boolean isShipped()
    {
        return isShipped;
    }

    public void setShipped(boolean isShipped)
    {
        this.isShipped = isShipped;
    }
}
