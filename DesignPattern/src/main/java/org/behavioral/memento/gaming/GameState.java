package org.behavioral.memento.gaming;

import java.util.ArrayList;
import java.util.List;

public class GameState
{
    private String playerPosition;
    private int playerHealth;
    private List<String> inventory;

    public GameState(String playerPosition, int playerHealth, List<String> inventory)
    {
        this.playerPosition = playerPosition;
        this.playerHealth = playerHealth;
        this.inventory = new ArrayList<>(inventory);
    }

    public String getPlayerPosition()
    {
        return playerPosition;
    }

    public int getPlayerHealth()
    {
        return playerHealth;
    }

    public List<String> getInventory()
    {
        return inventory;
    }

    public void setPlayerPosition(String playerPosition)
    {
        this.playerPosition = playerPosition;
    }

    public void setPlayerHealth(int playerHealth)
    {
        this.playerHealth = playerHealth;
    }

    public void setInventory(List<String> inventory)
    {
        this.inventory = inventory;
    }

    @Override
    public String toString()
    {
        return "GameState{" +
                "playerPosition='" + playerPosition + '\'' +
                ", playerHealth=" + playerHealth +
                ", inventory=" + inventory +
                '}';
    }
}
