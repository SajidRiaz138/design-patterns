package org.behavioral.client;

import org.behavioral.iterator.ArrayCollection;
import org.behavioral.iterator.ICollection;
import org.behavioral.iterator.Iterator;
import org.behavioral.iterator.LinkedListCollection;
import org.behavioral.iterator.Order;

import java.util.Date;

public class IteratorClient
{
    public static void main(String[] args)
    {
        // Using ArrayCollection
        ICollection<Order> arrayCollection = new ArrayCollection<>();
        arrayCollection.add(new Order("ORD001", new Date(), 250.0));
        arrayCollection.add(new Order("ORD002", new Date(), 150.0));
        arrayCollection.add(new Order("ORD003", new Date(), 350.0));

        System.out.println("Iterating over orders (ArrayCollection):");
        Iterator<Order> arrayIterator = arrayCollection.iterator();
        while (arrayIterator.hasNext())
        {
            System.out.println(arrayIterator.next());
        }

        // Using LinkedListCollection
        ICollection<Order> linkedListCollection = new LinkedListCollection<>();
        linkedListCollection.add(new Order("ORD101", new Date(), 260.0));
        linkedListCollection.add(new Order("ORD102", new Date(), 160.0));
        linkedListCollection.add(new Order("ORD103", new Date(), 360.0));

        System.out.println("\nIterating over orders (LinkedListCollection):");
        Iterator<Order> linkedListIterator = linkedListCollection.iterator();
        while (linkedListIterator.hasNext())
        {
            System.out.println(linkedListIterator.next());
        }
    }
}
