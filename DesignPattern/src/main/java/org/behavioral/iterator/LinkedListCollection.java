package org.behavioral.iterator;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListCollection<T> implements ICollection<T>
{
    private LinkedList<T> items;

    public LinkedListCollection()
    {
        this.items = new LinkedList<>();
    }

    @Override
    public void add(T item)
    {
        items.add(item);
    }

    @Override
    public T get(int index)
    {
        validateIndex(index);
        return items.get(index);
    }

    @Override
    public void remove(int index)
    {
        validateIndex(index);
        items.remove(index);
    }

    @Override
    public boolean contains(T item)
    {
        return items.contains(item);
    }

    @Override
    public int size()
    {
        return items.size();
    }

    @Override
    public Iterator<T> iterator()
    {
        return new LinkedListIterator();
    }

    private void validateIndex(int index)
    {
        if (index < 0 || index >= items.size())
        {
            throw new IndexOutOfBoundsException();
        }
    }

    private class LinkedListIterator implements Iterator<T>
    {
        private java.util.Iterator<T> iterator = items.iterator();
        private T currentItem;

        @Override
        public boolean hasNext()
        {
            return iterator.hasNext();
        }

        @Override
        public T next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            currentItem = iterator.next();
            return currentItem;
        }

        @Override
        public void remove()
        {
            if (currentItem == null)
            {
                throw new IllegalStateException();
            }
            iterator.remove();
            currentItem = null;
        }
    }
}
