package com.stickman.controller;

import com.stickman.model.*;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.media.*;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Controller class for handling game scenes and gameplay.
 */
public class SceneController {
   
    public ArrayList<Pillar> pList = new ArrayList<>();
    public ImageView playerImageView;
    public Text hs;
    @FXML
    public Text hst;
    public Text hs2;

    private Stage stage;
    private Game game;
    private Scene scene;

    public int getPillarCount() {
        return pillarCount;
    }

    public void setPillarCount(int pillarCount) {
        this.pillarCount = pillarCount;
    }

    private int pillarCount = 2;

    private Parent root;
    public Rectangle p1;
    public Rectangle p2;
    private Player player1;
    private int cherryCollected = 0;
    @FXML
    private Button invertButton;

    @FXML
    private ImageView cherryimage;
    @FXML
    private Text cher;

    @FXML
    private Text scoreText;
    @FXML
    private Text scoreText1;
    @FXML
    private Text saveText;

    @FXML
    AnchorPane gamePane;

    Line stick;
    double stickLength = 0.0;

    private int score = 0;
    private int highScore = 0;
    Timeline stickTimeline;

    private Timeline dropStickTimeline;
    private Timeline movePlayerTimeline;

    @FXML
    private Button opacityButton;

    /**
     * Switch to home menu scene.
     */
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/stickman/fxml/homemenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switch to load game scene.
     */
    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/stickman/fxml/LoadGame.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switch to save game scene.
     */
    public void savegamebutton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/stickman/fxml/SaveGame.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switch to game scene.
     */
    public void switchToScene3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/stickman/fxml/firstgameskeleton.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switch to pause menu.
     */
    public void switchToScene4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/stickman/fxml/pausemenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switch to load game 1.
     */
    public void switchToScene6(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/stickman/fxml/load1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switch to load game 2.
     */
    public void switchToScene7(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/stickman/fxml/load2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switch to load game 3.
     */
    public void switchToScene8(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/stickman/fxml/load3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switch to load game 4.
     */
    public void switchToScene9(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/stickman/fxml/load4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Exit the game.
     */
    public void exit1(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Handle stick extension on button press.
     */
    @FXML
    public void handleOpacityButtonPressed() {
        if (stick == null) {
            stick = new Line();
            stick.setStrokeWidth(5.0);
            gamePane.getChildren().add(stick);
        }
        deserializeHighScore();

        stickTimeline = new Timeline(
                new KeyFrame(Duration.millis(50), event -> {
                    stickLength -= 5.0;
                    updateStick();
                })
        );
        stickTimeline.setCycleCount(Timeline.INDEFINITE);
        stickTimeline.play();
    }

    /**
     * Handle stick release on button release.
     */
    @FXML
    public void handleOpacityButtonReleased() {
        if (stickTimeline != null) {
            stickTimeline.stop();
            dropStick();
        }
    }

    /**
     * Update stick position and length.
     */
    void updateStick() {
        stick.setStartX(162.0);
        stick.setStartY(212.0);
        stick.setEndX(162.0);
        stick.setEndY(212.0 + stickLength);
    }
    
    /**
     * Drop the stick.
     */
    private void dropStick() {
        // Implementation for dropping the stick
    }
    
    /**
     * Load high score from storage.
     */
    private void deserializeHighScore() {
        // Implementation for loading high score
    }
} 