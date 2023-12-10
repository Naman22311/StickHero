package com.ap.stickman;

import com.ap.model.*;
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
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Scenecontroller {
   
    public ArrayList<Pillar> pList= new ArrayList<>();
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
    private int cherryCollected=0;
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

    private int score=0;
    private int highScore=0;
    Timeline stickTimeline;

    private Timeline dropStickTimeline;
    private Timeline movePlayerTimeline;

    @FXML
    private Button opacityButton;

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("homemenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoadGame.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void savegamebutton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SaveGame.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("firstgameskeleton.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pausemenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene6(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("load1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene7(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("load2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene8(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("load3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene9(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("load4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void exit1(ActionEvent event) {
        Platform.exit();
    }




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

    @FXML
    public void handleOpacityButtonReleased() {
        if (stickTimeline != null) {
            stickTimeline.stop();
            dropStick();

        }

    }

    void updateStick() {
        stick.setStartX(162.0);
        stick.setStartY(212.0);
        stick.setEndX(162.0);
        stick.setEndY(212.0 + stickLength);
    }
    public void invert(){
        TranslateTransition flip = new TranslateTransition(Duration.millis(200), playerImageView);
        flip.setByY(playerImageView.getFitHeight());
    }


    private void dropStick() {
        double endX = stick.getEndX();
        double endY = stick.getEndY();


        double midPointY = (212 + 212 + stickLength) / 2;


        RotateTransition rotateTransition = new RotateTransition(Duration.millis(500), stick);
        rotateTransition.setByAngle(90);


        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), stick);
        translateTransition.setByY(midPointY - endY);
        translateTransition.setByX(-(stickLength/2));



        ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, translateTransition);
        TranslateTransition p1 = new TranslateTransition();



        parallelTransition.play();
        parallelTransition.setOnFinished(event -> {
            movePlayerOnStick();


        });

    }




    @FXML
    void movePlayerOnStick() {

        TranslateTransition t1= new TranslateTransition(Duration.millis(1000), playerImageView);
        t1.setToX((stick.getStartY())-(stick.getEndY()));

        t1.play();


        t1.setOnFinished(actionEvent -> {

            removeStick();
        });
        String pil="pillarNo"+(pillarCount-3);
        gamePane.getChildren().removeIf(node -> node.getId() != null && node.getId().startsWith(pil));

    }


    private void removeStick() {
        double n = (stick.getStartY())-(stick.getEndY());

        stickLength = 0.0;
        gamePane.getChildren().remove(stick);
        stick = null;
        double pillarStartX = 180;


        if (n<pillarStartX || n>300 ) {

            fallPlayer(n);

        }  else {
            collectCherries();
            String pil="pillarNo"+(pillarCount-2);
            gamePane.getChildren().removeIf(node -> node.getId() != null && node.getId().startsWith(pil));


            scoreText.setText("SCORE " + ++score);



            playSound("src/main/resources/com/ap/stickman/score.mp3");


            TranslateTransition pop = new TranslateTransition(Duration.millis(300), playerImageView);
            pop.setToX(p2.getX() + p2.getWidth());
            pop.play();
            MovePillar();
        }

    }
    public static void playSound(String filePath) {
        Media sound = new Media(new File(filePath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);


        mediaPlayer.setAutoPlay(true);


         mediaPlayer.setCycleCount(1);
    }
    private void fallPlayer(double n) {

        TranslateTransition fallTransition = new TranslateTransition(Duration.millis(500), playerImageView);
        fallTransition.setByY(200);

        fallTransition.play();
        fallTransition.setOnFinished(event -> {
            if (cherryCollected>1) {
                cherryCollected=cherryCollected-2;
                cher.setText(String.valueOf(cherryCollected));

                TranslateTransition t1 = new TranslateTransition(Duration.millis(800), playerImageView);
                TranslateTransition t2 = new TranslateTransition(Duration.millis(800),playerImageView);
                if (n<70){
                t1.setByX(-110);
                t2.setByY(-200);}
                else if (n>70 && n< 300){
                    t1.setByX(-170);
                    t2.setByY(-200);}

                else if (n>300 && n<370) {
                    t1.setByX(-350);
                    t2.setByY(-200);
                }
                else {
                    t1.setByX(-440);
                    t2.setByY(-200);
                }
                t1.play();
                t2.play();

            }
            else{

                try {
                    serializeHighScore();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Retryscreen.fxml"));
                    Parent retryScreen = loader.load();

                    Stage currentStage = (Stage) playerImageView.getScene().getWindow();

                    deserializeHighScore();

                    // Find and update the Text node with ID "hs" in the loaded FXML hierarchy
                    ObservableList<Node> nodes = retryScreen.getChildrenUnmodifiable();
                    for (Node node : nodes) {
                        if (Objects.equals(node.getId(), "hs") && node instanceof Text) {
                            ((Text) node).setText("High Score : " + highScore);
                        }
                        if (Objects.equals(node.getId(), "hs2") && node instanceof Text){
                            ((Text) node).setText("Score : " + score);
                        }
                    }

                    Scene retryScene = new Scene(retryScreen);
                    currentStage.setScene(retryScene);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }});
    }
private void MovePillar() {

    gamePane.getChildren().remove(p1);


    TranslateTransition t2 = new TranslateTransition(Duration.millis(800), p2);
    generatecherry();
    generateAndShowPillars();
    TranslateTransition t1 = new TranslateTransition(Duration.millis(800), playerImageView);
    t2.setByX(-162 - 124);
    t1.setByX(-162 -124);

    t2.play();
    t1.play();


    String pil1 = "pillarNo" + (pillarCount - 2);
    Node node = gamePane.lookup("#" + pil1);
    Rectangle newPillar = (Rectangle) gamePane.lookup(pil1);
    TranslateTransition newPillarTransition = new TranslateTransition(Duration.millis(800), node);

    newPillarTransition.setToX(node.getTranslateX() - 162 - 124);

    newPillarTransition.play();



    newPillarTransition.setOnFinished(event -> {

        gamePane.getChildren().remove(p2);


    });


}
    void generatecherry() {
        double probability = 0.3;

        boolean shouldGenerateCherry = getRandomBooleanWithOdds(probability);

        if (shouldGenerateCherry) {
            cherryimage.setOpacity(1);
        } else {
            cherryimage.setOpacity(0);
        }
    }

    public static boolean getRandomBooleanWithOdds(double probability) {
        if (probability < 0.0 || probability > 1.0) {
            throw new IllegalArgumentException("Probability must be between 0.0 and 1.0");
        }

        Random random = new Random();
        return random.nextDouble() < probability;
    }

    void generateAndShowPillars() {

        ArrayList <Integer> pillar_width=new ArrayList<>();
        pillar_width.add(99);
        pillar_width.add(95);
        pillar_width.add(110);
        pillar_width.add(107);
        pillar_width.add(103);
        pillar_width.add(115);
        pillar_width.add(120);

        Random random = new Random();
        double pillarWidth = pillar_width.get(random.nextInt(7));

        Pillar newPillar = new Pillar();
        newPillar.setWidth(pillarWidth);
        newPillar.setHeight(129.0);
        newPillar.setArcWidth(5.0);
        newPillar.setStroke(Paint.valueOf("Black"));
        newPillar.setFill(Paint.valueOf("#004a8f"));

        // Set the position of the new pillar
        newPillar.setX(300 + 50);
        newPillar.setY(212.0);
        pList.add(newPillar);

        // Add the new pillar to the list and gamePane
        newPillar.setId("pillarNo" + pillarCount);
        gamePane.getChildren().add(newPillar);

        pillarCount++;
    }
    private Random random;
    public void setRandomForTesting(int value) {

        this.random = new FixedRandom(value);
    }

    public List<Pillar> getPillarsList() {
        return pList;
    }

    // Add this inner class to generate fixed random numbers for testing
    private static class FixedRandom extends Random {
        private final int value;

        public FixedRandom(int value) {
            this.value = value;
        }

        @Override
        public int nextInt(int bound) {
            return value;
        }
    }
    private void collectCherries(){
        if (cherryimage.getOpacity() == 1){
            cherryCollected += 1;
            cher.setText(String.valueOf(cherryCollected));

        }

    }


    /* The Memento Pattern is implemented through the `gameSerializable` and `gameDeserializable` methods.
    The `gameSerializable` method allows you to save the state of a `Game` object when the "Save Game" button is clicked.
    This enables the `GameObject` to be serialized and stored.
     Later, the game can be deserialized, and the `Game` object can be restored to its previous state when the "Load" button is clicked.*/






    @FXML
    private void gameSerializable() throws IOException, ClassNotFoundException {

        game = new Game();
        player1 = new Player();
        game.setPlayer(player1);

        ScoreCard sc = new ScoreCard(score);
        game.getPlayer().setScoreCard(sc);
        game.getPlayer().setEarnedCherries(cherryCollected);

        GameRegistry games = GameRegistry.getInstance();
        games.getGames().add(game);
        ObjectOutputStream out = null;

        ObjectInputStream in = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("GamesOutput.txt"));
            out.writeObject(game);
            serializeHighScore();
        }
        finally {
            out.close();

        }
    }


    @FXML
    private void serializeHighScore()  {

        ObjectOutputStream highout = null;
        ObjectInputStream in = null;
        try {

            in = new ObjectInputStream(new FileInputStream("HighScoreOutput.txt"));
            ScoreCard highScore = (ScoreCard) in.readObject();

            if (highScore == null || (highScore.getScore() < score)){
                highout = new ObjectOutputStream(new FileOutputStream("HighScoreOutput.txt"));
                highout.writeObject(new ScoreCard(score));

            }

        } catch( Exception e) {
            try {
                highout = new ObjectOutputStream(new FileOutputStream("HighScoreOutput.txt"));
                highout.writeObject(new ScoreCard(score));
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        finally {
            try {
                highout.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    // memento pattern
    @FXML
    private void gameDeserializable() throws IOException, ClassNotFoundException {

        ObjectInputStream in = null;
        // Singleton pattern in  GameRegistry class
        GameRegistry gamesreturned;
        GameRegistry games =GameRegistry.getInstance();
        games.getGames().add(game);
        try {
            in = new ObjectInputStream(new FileInputStream("GamesOutput.txt"));
            game = (Game) in.readObject();
            score = game.getPlayer().getScoreCard().getScore();
            cherryCollected=game.getPlayer().getEarnedCherries();
            System.out.println("scoreResume :" + score);

            scoreText.setText("SCORE " + score);
            cher.setText(String.valueOf(cherryCollected));

        } finally {
            System.out.println("Game saved successfully!!");
            in.close();
        }


    }

    @FXML

    private void deserializeHighScore() {

        ObjectInputStream in = null;
        // Singleton pattern in  GameRegistry class
        GameRegistry gamesreturned;
        GameRegistry games =GameRegistry.getInstance();
        games.getGames().add(game);

        try {
            in = new ObjectInputStream(new FileInputStream("HighScoreOutput.txt"));
            ScoreCard highScoreCard = (ScoreCard) in.readObject();
            highScore = highScoreCard.getScore();

            hst.setText("High Score : " + highScore);




        } catch(Exception e){
            e.printStackTrace();
        }
        finally {

            try {
                in.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
    private MediaPlayer bgMediaPlayer;
    public void initialize() {
        // Load background music
        Media bgMusic = new Media(new File("src/main/resources/com/ap/stickman/Sakura-Girl-Daisy-chosic.com_.mp3").toURI().toString());
        bgMediaPlayer = new MediaPlayer(bgMusic);
        bgMediaPlayer.setVolume(0.5);
        bgMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        bgMediaPlayer.play();
    }



}






