package org.behavioral.iterator;

import java.util.NoSuchElementException;

public class ArrayCollection<T> implements ICollection<T>
{
    private T[] items;
    private int count;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings ("unchecked")
    public ArrayCollection()
    {
        this.items = (T[]) new Object[INITIAL_CAPACITY];
        this.count = 0;
    }

    @Override
    public void add(T item)
    {
        ensureCapacity();
        items[count++] = item;
    }

    @Override
    public T get(int index)
    {
        validateIndex(index);
        return items[index];
    }

    @Override
    public void remove(int index)
    {
        validateIndex(index);
        shiftLeft(index);
        items[--count] = null; // Avoid memory leak
        shrinkIfNeeded();
    }

    @Override
    public boolean contains(T item)
    {
        for (int i = 0; i < count; i++)
        {
            if (items[i].equals(item))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size()
    {
        return count;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new ArrayIterator();
    }

    private void ensureCapacity()
    {
        if (count == items.length)
        {
            resize(2 * items.length);
        }
    }

    private void shrinkIfNeeded()
    {
        if (count > 0 && count == items.length / 4)
        {
            resize(items.length / 2);
        }
    }

    @SuppressWarnings ("unchecked")
    private void resize(int newCapacity)
    {
        T[] temp = (T[]) new Object[newCapacity];
        System.arraycopy(items, 0, temp, 0, count);
        items = temp;
    }

    private void validateIndex(int index)
    {
        if (index < 0 || index >= count)
        {
            throw new IndexOutOfBoundsException();
        }
    }

    private void shiftLeft(int index)
    {
        for (int i = index; i < count - 1; i++)
        {
            items[i] = items[i + 1];
        }
    }

    private class ArrayIterator implements Iterator<T>
    {
        private int currentIndex = 0;

        @Override
        public boolean hasNext()
        {
            return currentIndex < count;
        }

        @Override
        public T next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            return items[currentIndex++];
        }

        @Override
        public void remove()
        {
            if (currentIndex <= 0 || currentIndex > count)
            {
                throw new IllegalStateException();
            }
            ArrayCollection.this.remove(--currentIndex);
        }
    }
}
