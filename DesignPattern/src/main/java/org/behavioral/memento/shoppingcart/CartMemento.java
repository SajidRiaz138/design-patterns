package org.behavioral.memento.shoppingcart;

import java.util.List;
import java.util.stream.Collectors;

public class CartMemento
{
    private final List<CartItem> state;
    private final long timestamp;

    public CartMemento(List<CartItem> state)
    {
        this.state = state.stream()
                .map(item -> new CartItem(item.getItemId(), item.getName(), item.getPrice(), item.getQuantity()))
                .collect(Collectors.toList());
        this.timestamp = System.currentTimeMillis();
    }

    public List<CartItem> getState()
    {
        return state;
    }

    public long getTimestamp()
    {
        return timestamp;
    }
}
