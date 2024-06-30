package org.behavioral.memento.gaming;

public class GameMemento
{
    private final GameState state;

    public GameMemento(GameState state)
    {
        this.state = new GameState(state.getPlayerPosition(), state.getPlayerHealth(), state.getInventory());
    }

    public GameState getState()
    {
        return state;
    }
}
