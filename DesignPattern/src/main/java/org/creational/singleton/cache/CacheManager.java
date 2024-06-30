package org.creational.singleton.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public enum CacheManager
{
    INSTANCE;

    private final ConcurrentMap<String, CacheEntry> cache = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    CacheManager()
    {
        // Clean up expired cache entries periodically
        scheduler.scheduleAtFixedRate(this::removeExpiredEntries, 0, 1, TimeUnit.MINUTES);
    }

    public void put(String key, Object value, long ttlInSeconds)
    {
        long expiryTime = ttlInSeconds > 0 ? System.currentTimeMillis() + ttlInSeconds * 1000 : -1;
        cache.put(key, new CacheEntry(value, expiryTime));
    }

    public Object get(String key)
    {
        CacheEntry entry = cache.get(key);
        if (entry != null && (entry.expiryTime() < 0 || entry.expiryTime() > System.currentTimeMillis()))
        {
            return entry.value();
        }
        cache.remove(key);
        return null;
    }

    public void remove(String key)
    {
        cache.remove(key);
    }

    public void clear()
    {
        cache.clear();
    }

    private void removeExpiredEntries()
    {
        long now = System.currentTimeMillis();
        cache.entrySet().removeIf(entry -> entry.getValue().expiryTime() >= 0 && entry.getValue().expiryTime() <= now);
    }

    public void shutdown()
    {
        scheduler.shutdown();
        try
        {
            if (!scheduler.awaitTermination(60, TimeUnit.SECONDS))
            {
                scheduler.shutdownNow();
            }
        }
        catch (InterruptedException e)
        {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private static record CacheEntry(Object value, long expiryTime) {
    }

    public static void main(String[] args)
    {
        CacheManager cacheManager = CacheManager.INSTANCE;

        // Thread for putting entries into the cache
        Thread putThread = new Thread(() ->
        {
            for (int i = 0; i < 10; i++)
            {
                cacheManager.put("key" + i, "value" + i, 5 + i);
                System.out.println("Put key" + i);
                try
                {
                    Thread.sleep(500); // Sleep to simulate some delay
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Thread for getting entries from the cache
        Thread getThread = new Thread(() ->
        {
            for (int i = 0; i < 10; i++)
            {
                Object value = cacheManager.get("key" + i);
                System.out.println("Get key" + i + ": " + value);
                try
                {
                    Thread.sleep(700); // Sleep to simulate some delay
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Thread for removing entries from the cache
        Thread removeThread = new Thread(() ->
        {
            for (int i = 0; i < 10; i++)
            {
                cacheManager.remove("key" + i);
                System.out.println("Remove key" + i);
                try
                {
                    Thread.sleep(900); // Sleep to simulate some delay
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start the threads
        putThread.start();
        getThread.start();
        removeThread.start();

        // Wait for threads to finish
        try
        {
            putThread.join();
            getThread.join();
            removeThread.join();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }

        // Put some entries with TTL
        cacheManager.put("key1", "value1", 5);
        cacheManager.put("key2", "value2", 10);

        // Get entries
        System.out.println("key1: " + cacheManager.get("key1"));
        System.out.println("key2: " + cacheManager.get("key2"));

        // Sleep to let the TTL expire
        try
        {
            Thread.sleep(6000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // Get entries after TTL expiry
        System.out.println("key1 after TTL: " + cacheManager.get("key1"));
        System.out.println("key2 after TTL: " + cacheManager.get("key2"));

        // Shutdown the cache manager
        cacheManager.shutdown();
    }
}
