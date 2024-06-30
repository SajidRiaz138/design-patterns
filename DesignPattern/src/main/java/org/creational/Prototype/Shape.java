package org.creational.Prototype;

import java.util.HashMap;
import java.util.Map;

public abstract class Shape
{
    protected Map<String, String> metadata;

    public Shape()
    {
        this.metadata = new HashMap<>();
    }

    public Shape(Shape shape)
    {
        this.metadata = new HashMap<>(shape.metadata); // Deep copy of the metadata
    }

    public void addMetadata(String key, String value)
    {
        metadata.put(key, value);
    }

    @Override
    public String toString()
    {
        return "BaseShape{" + "metadata=" + metadata + '}';
    }

    @Override
    public abstract Shape clone();

    public abstract void draw();
}
