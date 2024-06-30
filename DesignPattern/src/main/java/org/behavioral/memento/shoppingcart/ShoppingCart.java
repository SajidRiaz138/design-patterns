package org.behavioral.memento.shoppingcart;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ShoppingCart
{
    private static final int MAX_STACK_SIZE = 10;
    private List<CartItem> items = new ArrayList<>();
    private Stack<CartMemento> undoStack = new Stack<>();
    private Stack<CartMemento> redoStack = new Stack<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private String userId;

    public ShoppingCart(String userId)
    {
        this.userId = userId;
    }

    public void addItem(CartItem item)
    {
        lock.writeLock().lock();
        try
        {
            saveState();
            redoStack.clear();
            items.add(item);
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    public void removeItem(String itemId)
    {
        lock.writeLock().lock();
        try
        {
            saveState();
            redoStack.clear();
            items.removeIf(item -> item.getItemId().equals(itemId));
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    public void updateItemQuantity(String itemId, int newQuantity)
    {
        lock.writeLock().lock();
        try
        {
            saveState();
            redoStack.clear();
            for (CartItem item : items)
            {
                if (item.getItemId().equals(itemId))
                {
                    item.setQuantity(newQuantity);
                    break;
                }
            }
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    public void undo()
    {
        lock.writeLock().lock();
        try
        {
            if (!undoStack.isEmpty())
            {
                redoStack.push(new CartMemento(items));
                items = undoStack.pop().getState();
            }
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    public void redo()
    {
        lock.writeLock().lock();
        try
        {

            if (!redoStack.isEmpty())
            {
                undoStack.push(new CartMemento(items));
                items = redoStack.pop().getState();
            }
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    private void saveState()
    {
        if (undoStack.size() >= MAX_STACK_SIZE)
        {
            undoStack.removeElementAt(0);
        }
        undoStack.push(new CartMemento(items));
    }

    public List<CartItem> getItems()
    {
        return Collections.unmodifiableList(items);
    }
}
