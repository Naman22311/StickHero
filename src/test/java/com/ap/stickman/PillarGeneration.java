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

public class  PillarGeneration{

    private Scenecontroller sceneController;



    @BeforeEach
    public void setUp() {
        sceneController = new Scenecontroller();

        // Initialize gamePane for testing
        sceneController.gamePane = new AnchorPane();
    }


    @Test
    public void testGenerateAndShowPillars() {
        // Set a fixed random number generator for testing
        sceneController.setRandomForTesting(2); // Choose an index for testing

        // Call the method to generate and show pillars
        sceneController.generateAndShowPillars();

        // Retrieve the list of pillars from the controller
        List<Pillar> pillars = sceneController.getPillarsList();

        // Assert that the list contains one pillar
        assertEquals(1, pillars.size());

        // Assert properties of the added pillar
        Pillar addedPillar = pillars.get(0);
        assertNotNull(addedPillar);
        assertEquals("pillarNo" + 2, addedPillar.getId()); // Assuming initial pillarCount is 2
        assertEquals(129.0, addedPillar.getHeight());
        assertEquals(5.0, addedPillar.getArcWidth());
        assertEquals(Paint.valueOf("Black"), addedPillar.getStroke());
        assertEquals(Paint.valueOf("#004a8f"), addedPillar.getFill());
        assertEquals(300 + 50, addedPillar.getX());
        assertEquals(212.0, addedPillar.getY());
    }
}
