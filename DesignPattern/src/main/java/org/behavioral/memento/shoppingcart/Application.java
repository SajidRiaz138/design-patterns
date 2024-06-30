package org.behavioral.memento.shoppingcart;

public class Application
{
    public static void main(String[] args)
    {
        ShoppingCart cart = new ShoppingCart("user123");

        // Add items to the cart
        cart.addItem(new CartItem("item1", "Laptop", 999.99, 1));
        cart.addItem(new CartItem("item2", "Mouse", 19.99, 2));
        cart.addItem(new CartItem("item3", "Keyboard", 49.99, 1));

        System.out.println("Cart after adding items: " + cart.getItems());

        // Remove an item
        cart.removeItem("item2");
        System.out.println("Cart after removing an item: " + cart.getItems());

        // Update item quantity
        cart.updateItemQuantity("item1", 2);
        System.out.println("Cart after updating item quantity: " + cart.getItems());

        // Undo the last action (update quantity)
        cart.undo();
        System.out.println("Cart after undo: " + cart.getItems());

        // Redo the last undone action (update quantity)
        cart.redo();
        System.out.println("Cart after redo: " + cart.getItems());

        // Undo the last action (update item)
        cart.undo();
        System.out.println("Cart after undo: " + cart.getItems());
    }
}
