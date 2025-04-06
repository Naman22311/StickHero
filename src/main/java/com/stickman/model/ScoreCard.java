package com.stickman.model;

import java.io.Serializable;

/**
 * Represents the player's score in the game.
 */
public class ScoreCard implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int currentScore;
    private int highScore;
    private int cherryCount;

    public ScoreCard() {
        this.currentScore = 0;
        this.highScore = 0;
        this.cherryCount = 0;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
        if (currentScore > highScore) {
            highScore = currentScore;
        }
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getCherryCount() {
        return cherryCount;
    }

    public void setCherryCount(int cherryCount) {
        this.cherryCount = cherryCount;
    }

    public void incrementScore() {
        setCurrentScore(currentScore + 1);
    }

    public void incrementCherryCount() {
        this.cherryCount++;
    }
} 