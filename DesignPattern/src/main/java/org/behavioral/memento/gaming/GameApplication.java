package org.behavioral.memento.gaming;

import java.util.Arrays;

public class GameApplication
{
    public static void main(String[] args)
    {
        Game game = new Game();

        Long playerId = 1L;
        game.startGame(playerId, "Start", 100, Arrays.asList("Sword", "Shield"));

        game.printCurrentState(playerId);

        game.movePlayer(playerId, "Forest");
        game.updateHealth(playerId, 90);
        game.addItemToInventory(playerId, "Potion");

        game.printCurrentState(playerId);

        // Undo the last action (addItemToInventory)
        game.undo(playerId);
        game.printCurrentState(playerId);

        // Undo the second last action (updateHealth)
        game.undo(playerId);
        game.printCurrentState(playerId);

        // Redo the last undone action (updateHealth)
        game.redo(playerId);
        game.printCurrentState(playerId);

        // Set a checkpoint (autosave)
        game.setCheckpoint(playerId);

        // Make some changes
        game.movePlayer(playerId, "Castle");
        game.updateHealth(playerId, 80);

        game.printCurrentState(playerId);

        // Undo to the checkpoint
        game.undo(playerId);
        game.printCurrentState(playerId);
    }
}
