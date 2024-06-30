package org.behavioral.iterator;

public interface ICollection<T>
{
    void add(T item);
    T get(int index);
    void remove(int index);
    boolean contains(T item);
    int size();
    Iterator<T> iterator();
}
