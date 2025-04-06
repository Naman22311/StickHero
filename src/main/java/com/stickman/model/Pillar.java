package com.stickman.model;

import java.io.Serializable;

/**
 * Represents a pillar in the game that the player must cross.
 */
public class Pillar implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private double positionX;
    private double width;
    private double height;

    public Pillar(double positionX, double width, double height) {
        this.positionX = positionX;
        this.width = width;
        this.height = height;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
} 