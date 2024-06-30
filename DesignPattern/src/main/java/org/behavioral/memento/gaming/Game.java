package org.behavioral.memento.gaming;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Game
{
    private final Map<Long, GameState> currentState = new HashMap<>();
    private final Map<Long, Deque<GameMemento>> undoOperations = new HashMap<>();
    private final Map<Long, Deque<GameMemento>> redoOperations = new HashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void startGame(Long playerId, String initialPosition, int initialHealth, List<String> initialInventory)
    {
        lock.writeLock().lock();
        try
        {
            GameState initialState = new GameState(initialPosition, initialHealth, initialInventory);
            currentState.put(playerId, initialState);
            undoOperations.put(playerId, new ArrayDeque<>());
            redoOperations.put(playerId, new ArrayDeque<>());
            saveState(playerId);
            System.out.println("Game started for player " + playerId);
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    public void movePlayer(Long playerId, String newPosition)
    {
        lock.writeLock().lock();
        try
        {
            saveState(playerId);
            clearRedoStack(playerId);
            currentState.get(playerId).setPlayerPosition(newPosition);
            System.out.println("Player " + playerId + " moved to: " + newPosition);
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    public void updateHealth(Long playerId, int newHealth)
    {
        lock.writeLock().lock();
        try
        {
            saveState(playerId);
            clearRedoStack(playerId);
            currentState.get(playerId).setPlayerHealth(newHealth);
            System.out.println("Player " + playerId + " health updated to: " + newHealth);
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    public void addItemToInventory(Long playerId, String item)
    {
        lock.writeLock().lock();
        try
        {
            saveState(playerId);
            clearRedoStack(playerId);
            currentState.get(playerId).getInventory().add(item);
            System.out.println("Player " + playerId + " added item to inventory: " + item);
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    public void undo(Long playerId)
    {
        lock.writeLock().lock();
        try
        {
            if (!undoOperations.get(playerId).isEmpty())
            {
                redoOperations.get(playerId).push(new GameMemento(currentState.get(playerId)));
                currentState.put(playerId, undoOperations.get(playerId).pop().getState());
                System.out.println("Undo for player " + playerId + ": " + currentState.get(playerId));
            }
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    public void redo(Long playerId)
    {
        lock.writeLock().lock();
        try
        {
            if (!redoOperations.get(playerId).isEmpty())
            {
                undoOperations.get(playerId).push(new GameMemento(currentState.get(playerId)));
                currentState.put(playerId, redoOperations.get(playerId).pop().getState());
                System.out.println("Redo for player " + playerId + ": " + currentState.get(playerId));
            }
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    public void setCheckpoint(Long playerId)
    {
        lock.writeLock().lock();
        try
        {
            saveState(playerId);
            System.out.println("Checkpoint set for player " + playerId);
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }

    private void saveState(Long playerId)
    {
        undoOperations.get(playerId).push(new GameMemento(currentState.get(playerId)));
    }

    private void clearRedoStack(Long playerId)
    {
        redoOperations.get(playerId).clear();
    }

    public GameState getCurrentState(Long playerId)
    {
        lock.readLock().lock();
        try
        {
            return currentState.get(playerId);
        }
        finally
        {
            lock.readLock().unlock();
        }
    }

    public void printCurrentState(Long playerId)
    {
        System.out.println("Current State for player " + playerId + ": " + getCurrentState(playerId));
    }
}
