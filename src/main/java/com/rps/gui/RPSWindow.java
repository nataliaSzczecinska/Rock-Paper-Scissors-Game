package com.rps.gui;

import com.rps.game.*;
import com.rps.gui.elements.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RPSWindow extends GameWindow {

    private static final String TITLE = "The Rock-Paper-Scissors Game";

    public RPSWindow(RPSGame game, Stage mainStage) {
        super(game, mainStage, TITLE);

        AnchorPane gameArea = gameAreaPane();
        VBox gameResultDisplay = gameResultDisplayVBox();

        this.getChildren().addAll(gameArea, gameResultDisplay);
    }

    private AnchorPane gameAreaPane() {
        AnchorPane pane = new AnchorPane();
        log.info("The game area is created");

        pane.setPrefWidth(OPTIMUM_HIGH);
        pane.setBackground(BackgroundFactor.gameRPSWindow());

        ButtonSymbol [] symbols = new ButtonSymbol[3];

        symbols[0] = ButtonFactor.symbolButton(Symbol.ROCK);
        symbols[1] = ButtonFactor.symbolButton(Symbol.PAPER);
        symbols[2] = ButtonFactor.symbolButton(Symbol.SCISSORS);

        symbols[0].setLayoutX(215);
        symbols[0].setLayoutY(390);

        symbols[1].setLayoutX(410);
        symbols[1].setLayoutY(50);

        symbols[2].setLayoutX(25);
        symbols[2].setLayoutY(50);

        setAction(symbols);

        pane.getChildren().addAll(symbols);

        return pane;
    }


}
