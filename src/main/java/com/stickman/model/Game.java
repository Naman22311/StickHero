package com.stickman.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game instance with player, score, high score, and pillars.
 */
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Player player;
    private int score;
    private int highScore;
    private int cherryCollected;
    private List<Pillar> pillars;
    private boolean isPaused;

    public Game() {
        this.player = new Player();
        this.score = 0;
        this.highScore = 0;
        this.cherryCollected = 0;
        this.pillars = new ArrayList<>();
        this.isPaused = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getCherryCollected() {
        return cherryCollected;
    }

    public void setCherryCollected(int cherryCollected) {
        this.cherryCollected = cherryCollected;
    }

    public List<Pillar> getPillars() {
        return pillars;
    }

    public void setPillars(List<Pillar> pillars) {
        this.pillars = pillars;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }
} 