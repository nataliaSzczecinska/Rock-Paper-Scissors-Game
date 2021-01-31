package com.rps;

import com.rps.gui.EntryWindow;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RockPaperScissorsGameApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent firstWindow = new EntryWindow(stage);
        Scene firstScene = new Scene(firstWindow);

        stage.setScene(firstScene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
