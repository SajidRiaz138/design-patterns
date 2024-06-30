package org.behavioral.mediator;

public class InventoryService
{
    public boolean validate(Cart cart)
    {
        // Simulate inventory validation logic
        System.out.println("Validating inventory for items: " + cart.getItems());
        boolean isValid = true; // Assume validation is successful
        cart.setValid(isValid);
        return isValid;
    }

    public void updateInventory(Cart cart)
    {
        if (cart.isValid())
        {
            System.out.println("Updating inventory for items: " + cart.getItems());
        }
        else
        {
            System.out.println("Cannot update inventory: Cart is not valid.");
        }
    }
}
