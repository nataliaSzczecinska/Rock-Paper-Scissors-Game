package com.rps.gui;

import com.rps.game.*;
import com.rps.gui.elements.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class EndGameWindow {

    protected static final Logger log = Logger.getLogger(EndGameWindow.class.getName());

    public static void displayEndGameWindow(RPSGame game, Stage mainStage, String title) {
        Stage newWindow = new Stage();

        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(mainStage);
        newWindow.setWidth(600);
        newWindow.setTitle(title);
        newWindow.centerOnScreen();
        newWindow.setResizable(false);

        newWindow.setScene(new Scene(vBoxDisplay(game, newWindow, mainStage)));
        newWindow.show();
    }

    private static VBox vBoxDisplay(RPSGame game, Stage thisWindow, Stage mainWindow) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(BackgroundFactor.entryWindow());

        game.currentStatisticDisplay();
        String text = new String();

        log.info("First player win: " + game.getStatistic().getFirstPlayerWin() + "rounds");
        log.info("Second player win: " + game.getStatistic().getSecondPlayerWin() + "rounds");
        log.info("The winner round limits: " + game.getStatistic().getNumberOfGameToWin() + "rounds");

        if (game.getStatistic().getNumberOfGameToWin() == game.getStatistic().getFirstPlayerWin()) {
            text += "Congratulation ";
            text += game.getFirstPlayer().getName();
            text += ", you WIN!";
        } else if (game.getStatistic().getNumberOfGameToWin() == game.getStatistic().getSecondPlayerWin()) {
            text += "Congratulation ";
            text += game.getSecondPlayer().getName();
            text += ", you WIN!";
        } else {
            log.warning("The game do not have a result!");
        }

        Text endingText = TextFactor.textDisplayTimesNewRoman16(text);
        Text questionWhatNext = TextFactor.textDisplayTimesNewRoman16("What do you want to do next? ");

        Button playAgain = ButtonFactor.optionsButton("PLAY AGAIN");
        Button startNewGame = ButtonFactor.optionsButton("START NEW GAME");
        Button endGame = ButtonFactor.optionsButton("END GAME");

        playAgain.setOnAction(action -> {
            game.getStatistic().clearStatistic();
            game.getFirstPlayer().setMoveNow(true);
            game.getSecondPlayer().setMoveNow(false);

            mainWindow.setScene(new Scene(new RPSWindow(game, mainWindow)));

            thisWindow.close();
        });

        startNewGame.setOnAction(action -> {
            thisWindow.close();
            mainWindow.setScene(new Scene(new EntryWindow(mainWindow)));
        });

        endGame.setOnAction(action -> {
            thisWindow.close();
            mainWindow.close();
        });

        HBox buttonPane = new HBox();

        buttonPane.setSpacing(15);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.getChildren().addAll(playAgain, startNewGame, endGame);

        vBox.getChildren().addAll(endingText, questionWhatNext, buttonPane);

        return vBox;
    }
}
