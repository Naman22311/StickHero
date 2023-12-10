module com.example.stickman {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.ap.stickman to javafx.fxml;
    exports com.ap.stickman;
}