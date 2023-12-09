// MainController.java
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MainController {
    @FXML
    private StackPane root;

    @FXML
    private AnchorPane mainScreen;

    @FXML
    private AnchorPane loadGameScreen;

    public void initialize() {
        // Initially, show the main screen and hide the load game screen
        mainScreen.setVisible(true);
        loadGameScreen.setVisible(false);
    }

    // Method to handle the "Load Game" button click
    public void loadGame() {
        // Hide the main screen and show the load game screen
        mainScreen.setVisible(false);
        loadGameScreen.setVisible(true);
    }
}
