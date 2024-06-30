package org.creational.Prototype;

public class Circle extends Shape
{
    private int radius;

    public Circle(int radius)
    {
        super();
        this.radius = radius;
    }

    public Circle(Circle circle)
    {
        super(circle);
        this.radius = circle.radius;
    }

    @Override
    public Shape clone()
    {
        return new Circle(this);
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing a Circle with radius: " + radius);
    }

    @Override
    public String toString()
    {
        return "Circle{" + "radius=" + radius + ", metadata=" + metadata + '}';
    }
}
