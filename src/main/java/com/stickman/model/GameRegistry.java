package com.stickman.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Registry for saved games.
 */
public class GameRegistry implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Game> savedGames;
    private static GameRegistry instance;

    private GameRegistry() {
        this.savedGames = new ArrayList<>();
    }

    public static synchronized GameRegistry getInstance() {
        if (instance == null) {
            instance = new GameRegistry();
        }
        return instance;
    }

    public List<Game> getSavedGames() {
        return savedGames;
    }

    public void addSavedGame(Game game) {
        savedGames.add(game);
    }

    public Game getSavedGame(int index) {
        if (index >= 0 && index < savedGames.size()) {
            return savedGames.get(index);
        }
        return null;
    }

    public boolean removeSavedGame(int index) {
        if (index >= 0 && index < savedGames.size()) {
            savedGames.remove(index);
            return true;
        }
        return false;
    }

    public void clearSavedGames() {
        savedGames.clear();
    }
} 