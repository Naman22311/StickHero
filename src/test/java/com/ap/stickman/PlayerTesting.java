package com.ap.stickman;

import com.ap.model.Pillar;
import com.ap.model.Player;
import com.ap.model.ScoreCard;
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
public class PlayerTesting {
    public void testDefaultConstructor() {
        Player player = new Player();
        assertNotNull(player);
        assertNull(player.getScoreCard());
        assertEquals(0, player.getEarnedCherries());
    }

    @Test
    public void testParameterizedConstructor() {
        ScoreCard scoreCard = new ScoreCard();
        int earnedCherries = 10;
        Player player = new Player(scoreCard, earnedCherries);
        // Add assertions to test the parameterized constructor
        assertNotNull(player);
        assertEquals(scoreCard, player.getScoreCard());
        assertEquals(earnedCherries, player.getEarnedCherries());
    }

    @Test
    public void testSetScoreCard() {
        Player player = new Player();
        ScoreCard scoreCard = new ScoreCard();
        player.setScoreCard(scoreCard);

        assertEquals(scoreCard, player.getScoreCard());
    }

    @Test
    public void testSetEarnedCherries() {
        Player player = new Player();
        int earnedCherries = 20;
        player.setEarnedCherries(earnedCherries);
        assertEquals(earnedCherries, player.getEarnedCherries());
    }


}
