package org.creational.Prototype;

public class Rectangle extends Shape
{
    private int width;
    private int height;

    public Rectangle(int width, int height)
    {
        super();
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle rectangle)
    {
        super(rectangle);
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    @Override
    public Shape clone()
    {
        return new Rectangle(this);
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing a Rectangle with width: " + width + " and height: " + height);
    }

    @Override
    public String toString()
    {
        return "Rectangle{" + "width=" + width + ", height=" + height + ", metadata=" + metadata + '}';
    }
}
