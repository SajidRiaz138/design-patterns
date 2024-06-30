package org.creational.Prototype;

public class Client
{
    public static void main(String[] args)
    {
        PrototypeRegistry registry = new PrototypeRegistry();

        Circle circle = new Circle(10);
        circle.addMetadata("color", "red");
        registry.addPrototype("circle", circle);

        Rectangle rectangle = new Rectangle(20, 30);
        rectangle.addMetadata("border", "dashed");
        registry.addPrototype("rectangle", rectangle);

        Shape clonedCircle = registry.getPrototype("circle");
        Shape clonedRectangle = registry.getPrototype("rectangle");

        System.out.println(clonedCircle);
        System.out.println(clonedRectangle);

        clonedCircle.draw();
        clonedRectangle.draw();

        // Verifying deep copy
        circle.addMetadata("newKey", "newValue");
        System.out.println("Original Circle after modification: " + circle);
        System.out.println("Cloned Circle remains unchanged: " + clonedCircle);
    }
}
