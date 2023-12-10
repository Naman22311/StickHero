package com.ap.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Stick extends Rectangle {
    private int length;

    public static double STICK_WIDTH= 10;

    public static double DISPLAY_STICK_MIN_LENGTH= 10;

    public Stick() {
        super();
    }

    public Stick(double width, double height, Color color) {
        super(width,height,color);
    }
}