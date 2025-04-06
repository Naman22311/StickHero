module com.stickman {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.stickman.application to javafx.fxml;
    opens com.stickman.controller to javafx.fxml;
    opens com.stickman.model to javafx.base;
    
    exports com.stickman.application;
    exports com.stickman.controller;
    exports com.stickman.model;
    exports com.stickman.util;
}