package org.creational.Prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry
{
    private Map<String, Shape> registry = new HashMap<>();

    public void addPrototype(String key, Shape prototype)
    {
        registry.put(key, prototype);
    }

    public Shape getPrototype(String key)
    {
        Shape prototype = registry.get(key);
        return prototype != null ? prototype.clone() : null;
    }
}
