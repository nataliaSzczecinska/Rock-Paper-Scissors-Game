package com.rps.gui.elements;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BackgroundFactor {

    private static final Image IMAGE_BACKGROUND_ENTRY = new Image("file:src/main/resources/backgroundEntry.jpg");
    private static final Image IMAGE_BACKGROUND_ENTRY_TOP = new Image("file:src/main/resources/backgroundEntryTop.jpg");
    private static final Image IMAGE_BACKGROUND_RPS = new Image("file:src/main/resources/backgroundRPS.png");
    private static final Image IMAGE_BACKGROUND_RPSLS = new Image("file:src/main/resources/backgroundRPSLS.png");
    private static final BackgroundSize BACKGROUND_SIZE = new BackgroundSize(100, 100, true, true, true, true);
    private static final BackgroundImage BACKGROUND_IMAGE_ENTRY = new BackgroundImage(IMAGE_BACKGROUND_ENTRY, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BACKGROUND_SIZE);
    private static final BackgroundImage BACKGROUND_IMAGE_ENTRY_TOP = new BackgroundImage(IMAGE_BACKGROUND_ENTRY_TOP, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BACKGROUND_SIZE);
    private static final BackgroundImage BACKGROUND_IMAGE_RPS = new BackgroundImage(IMAGE_BACKGROUND_RPS, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BACKGROUND_SIZE);
    private static final BackgroundImage BACKGROUND_IMAGE_RPSLS = new BackgroundImage(IMAGE_BACKGROUND_RPSLS, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BACKGROUND_SIZE);
    private static final Background BACKGROUND_ENTRY = new Background(BACKGROUND_IMAGE_ENTRY);
    private static final Background BACKGROUND_ENTRY_TOP = new Background(BACKGROUND_IMAGE_ENTRY_TOP);
    private static final Background BACKGROUND_RPS = new Background(BACKGROUND_IMAGE_RPS);
    private static final Background BACKGROUND_RPSLS = new Background(BACKGROUND_IMAGE_RPSLS);

    public static Background entryWindow() {
        return BACKGROUND_ENTRY;
    }

    public static Background gameRPSWindow() {
        return BACKGROUND_RPS;
    }

    public static Background gameRPSLSWindow() {
        return BACKGROUND_RPSLS;
    }

    public static Background entryWindowTop() {
        return BACKGROUND_ENTRY_TOP;
    }
}
