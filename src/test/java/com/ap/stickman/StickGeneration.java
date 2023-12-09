package com.ap.stickman;

import com.ap.model.Pillar;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StickGeneration {
    private Scenecontroller sceneController;
    @BeforeEach
    public void setUp() {
        sceneController = new Scenecontroller();

        // Initialize gamePane for testing
        sceneController.gamePane = new AnchorPane();
    }


    @Test
    public void testUpdateStick() {
        sceneController.stick = new Line();

        // Call the method to update the stick
        sceneController.updateStick();

        assertNotNull(sceneController.stick);
        assertEquals(162.0, sceneController.stick.getStartX());
        assertEquals(212.0, sceneController.stick.getStartY());
        assertEquals(162.0, sceneController.stick.getEndX());
        assertEquals(212.0 + sceneController.stickLength, sceneController.stick.getEndY());
    }
}
