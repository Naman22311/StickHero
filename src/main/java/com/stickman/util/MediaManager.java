package com.stickman.util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for managing game sound effects and music.
 */
public class MediaManager {
    
    private static MediaManager instance;
    private MediaPlayer backgroundMusicPlayer;
    private final Map<String, MediaPlayer> soundEffects;
    private boolean isMuted;
    
    private MediaManager() {
        soundEffects = new HashMap<>();
        isMuted = false;
    }
    
    /**
     * Get the singleton instance of MediaManager.
     * 
     * @return The MediaManager instance
     */
    public static synchronized MediaManager getInstance() {
        if (instance == null) {
            instance = new MediaManager();
        }
        return instance;
    }
    
    /**
     * Play background music.
     * 
     * @param resourcePath Path to the music resource
     * @param loop Whether to loop the music
     */
    public void playBackgroundMusic(String resourcePath, boolean loop) {
        if (isMuted) {
            return;
        }
        
        stopBackgroundMusic();
        
        URL resourceUrl = getClass().getResource(resourcePath);
        if (resourceUrl != null) {
            Media music = new Media(resourceUrl.toString());
            backgroundMusicPlayer = new MediaPlayer(music);
            
            if (loop) {
                backgroundMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            }
            
            backgroundMusicPlayer.play();
        }
    }
    
    /**
     * Stop the background music.
     */
    public void stopBackgroundMusic() {
        if (backgroundMusicPlayer != null) {
            backgroundMusicPlayer.stop();
            backgroundMusicPlayer.dispose();
            backgroundMusicPlayer = null;
        }
    }
    
    /**
     * Play a sound effect.
     * 
     * @param name Name to identify the sound effect
     * @param resourcePath Path to the sound effect resource
     */
    public void playSoundEffect(String name, String resourcePath) {
        if (isMuted) {
            return;
        }
        
        URL resourceUrl = getClass().getResource(resourcePath);
        if (resourceUrl != null) {
            Media sound = new Media(resourceUrl.toString());
            MediaPlayer player = new MediaPlayer(sound);
            
            // Store the player for later cleanup
            soundEffects.put(name, player);
            
            player.setOnEndOfMedia(() -> {
                player.dispose();
                soundEffects.remove(name);
            });
            
            player.play();
        }
    }
    
    /**
     * Mute all sounds.
     */
    public void mute() {
        isMuted = true;
        
        if (backgroundMusicPlayer != null) {
            backgroundMusicPlayer.setMute(true);
        }
        
        for (MediaPlayer player : soundEffects.values()) {
            player.setMute(true);
        }
    }
    
    /**
     * Unmute all sounds.
     */
    public void unmute() {
        isMuted = false;
        
        if (backgroundMusicPlayer != null) {
            backgroundMusicPlayer.setMute(false);
        }
        
        for (MediaPlayer player : soundEffects.values()) {
            player.setMute(false);
        }
    }
    
    /**
     * Check if audio is muted.
     * 
     * @return True if muted, false otherwise
     */
    public boolean isMuted() {
        return isMuted;
    }
    
    /**
     * Toggle mute state.
     * 
     * @return New mute state
     */
    public boolean toggleMute() {
        if (isMuted) {
            unmute();
        } else {
            mute();
        }
        return isMuted;
    }
    
    /**
     * Clean up all media resources.
     */
    public void cleanup() {
        stopBackgroundMusic();
        
        for (MediaPlayer player : soundEffects.values()) {
            player.stop();
            player.dispose();
        }
        
        soundEffects.clear();
    }
} 