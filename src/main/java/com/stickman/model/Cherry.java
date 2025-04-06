package com.stickman.model;

import java.io.Serializable;

/**
 * Represents a cherry collectible in the game.
 */
public class Cherry implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private double positionX;
    private double positionY;
    private boolean collected;

    public Cherry(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.collected = false;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
} 