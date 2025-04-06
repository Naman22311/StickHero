package com.stickman.util;

import com.stickman.model.Game;
import com.stickman.model.GameRegistry;

import java.io.*;

/**
 * Utility class for serialization and deserialization of game data.
 */
public class GameSerializer {
    
    private static final String HIGH_SCORE_FILE = "highscore.dat";
    private static final String GAME_REGISTRY_FILE = "gameregistry.dat";
    
    /**
     * Save the high score to file.
     * 
     * @param highScore The high score to save
     * @return True if save was successful, false otherwise
     */
    public static boolean saveHighScore(int highScore) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(HIGH_SCORE_FILE))) {
            oos.writeInt(highScore);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Load the high score from file.
     * 
     * @return The loaded high score, or 0 if file doesn't exist or error occurs
     */
    public static int loadHighScore() {
        File file = new File(HIGH_SCORE_FILE);
        if (!file.exists()) {
            return 0;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(HIGH_SCORE_FILE))) {
            return ois.readInt();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * Save a game to the registry.
     * 
     * @param game The game to save
     * @return True if save was successful, false otherwise
     */
    public static boolean saveGame(Game game) {
        GameRegistry registry = GameRegistry.getInstance();
        registry.addSavedGame(game);
        return saveGameRegistry(registry);
    }
    
    /**
     * Save the game registry to file.
     * 
     * @param registry The game registry to save
     * @return True if save was successful, false otherwise
     */
    public static boolean saveGameRegistry(GameRegistry registry) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GAME_REGISTRY_FILE))) {
            oos.writeObject(registry);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Load the game registry from file.
     * 
     * @return The loaded game registry, or a new instance if file doesn't exist or error occurs
     */
    public static GameRegistry loadGameRegistry() {
        File file = new File(GAME_REGISTRY_FILE);
        if (!file.exists()) {
            return GameRegistry.getInstance();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(GAME_REGISTRY_FILE))) {
            return (GameRegistry) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return GameRegistry.getInstance();
        }
    }
} 
 