package com.ap.model;

import javafx.scene.shape.Rectangle;

public class Pillar extends Rectangle {

    private static final double PillarHeight = 212.0; // Fixed height of the pillars
    public double width;
    private double x;

    public Pillar(double width) {
        this.width = width;
    }


    public Pillar() {
    }
}
