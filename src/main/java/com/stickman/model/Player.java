package com.stickman.model;

import java.io.Serializable;

/**
 * Represents the player character in the game.
 */
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private double positionX;
    private double positionY;
    private boolean isMoving;
    private boolean isDead;
    private boolean isFacingRight;

    public Player() {
        this.positionX = 0;
        this.positionY = 0;
        this.isMoving = false;
        this.isDead = false;
        this.isFacingRight = true;
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

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setFacingRight(boolean facingRight) {
        isFacingRight = facingRight;
    }
} 