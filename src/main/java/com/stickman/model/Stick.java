package com.stickman.model;

import java.io.Serializable;

/**
 * Represents the stick that extends to cross between pillars.
 */
public class Stick implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private double positionX;
    private double positionY;
    private double length;
    private boolean isExtending;
    private boolean isDropping;

    public Stick(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.length = 0;
        this.isExtending = false;
        this.isDropping = false;
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isExtending() {
        return isExtending;
    }

    public void setExtending(boolean extending) {
        isExtending = extending;
    }

    public boolean isDropping() {
        return isDropping;
    }

    public void setDropping(boolean dropping) {
        isDropping = dropping;
    }
} 