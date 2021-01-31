package com.rps.gui;

import com.rps.game.ComputerPlayer;
import com.rps.game.RPSGame;
import com.rps.game.Symbol;
import com.rps.gui.elements.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RPSLSWindow extends GameWindow {

    private static final String TITLE = "The Rock-Paper-Scissors-Lizard-Spock Game";

    public RPSLSWindow(RPSGame game, Stage mainStage) {
        super(game, mainStage, TITLE);

        AnchorPane gameArea = gameAreaPane();
        VBox gameResultDisplay = gameResultDisplayVBox();

        this.getChildren().addAll(gameArea, gameResultDisplay);
    }

    private AnchorPane gameAreaPane() {
        AnchorPane pane = new AnchorPane();
        pane.setPrefWidth(OPTIMUM_HIGH);
        pane.setBackground(BackgroundFactor.gameRPSLSWindow());

        ButtonSymbol [] symbols = new ButtonSymbol[5];

        symbols[0] = ButtonFactor.symbolButton(Symbol.ROCK);
        symbols[1] = ButtonFactor.symbolButton(Symbol.PAPER);
        symbols[2] = ButtonFactor.symbolButton(Symbol.SCISSORS);
        symbols[3] = ButtonFactor.symbolButton(Symbol.LIZARD);
        symbols[4] = ButtonFactor.symbolButton(Symbol.SPOCK);

        symbols[0].setLayoutX(334);
        symbols[0].setLayoutY(391);

        symbols[1].setLayoutX(402);
        symbols[1].setLayoutY(163);

        symbols[2].setLayoutX(207);
        symbols[2].setLayoutY(27);

        symbols[3].setLayoutX(97);
        symbols[3].setLayoutY(394);

        symbols[4].setLayoutX(22);
        symbols[4].setLayoutY(165);

        setAction(symbols);

        pane.getChildren().addAll(symbols);

        return pane;
    }
}
