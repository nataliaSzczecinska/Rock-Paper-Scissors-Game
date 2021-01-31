package com.rps.gui;

import com.rps.game.ComputerPlayer;
import com.rps.game.Player;
import com.rps.game.RPSGame;
import com.rps.game.RealPlayer;
import com.rps.gui.elements.BackgroundFactor;
import com.rps.gui.elements.ButtonFactor;
import com.rps.gui.elements.TextFactor;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class EntryWindow extends VBox {
    protected final Logger log = Logger.getLogger(getClass().getName());

    private int gameVersionNumber = 1;

    public EntryWindow(Stage mainStage) {
        super();

        mainStage.setTitle("The Rock-Paper-Scissors Game");
        mainStage.setWidth(800);
        mainStage.centerOnScreen();

        this.setBackground(BackgroundFactor.entryWindow());
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

        VBox top = new VBox();

        top.setAlignment(Pos.CENTER);
        top.setBackground(BackgroundFactor.entryWindowTop());
        top.setSpacing(15);

        Text welcome = TextFactor.textDisplayArial20WithUnderline("WELCOME!");
        Text letUsStart = TextFactor.textDisplayArial18("Let us start the game.");
        Text choseGameOption = TextFactor.textDisplayArial16("Please, select game options bellow.");

        top.getChildren().addAll(welcome, letUsStart, choseGameOption);

        this.getChildren().add(top);

        Text gameVersion = TextFactor.textDisplayTimesNewRoman16("Which version of game you want to play?");

        ToggleGroup gameVersionOption = new ToggleGroup();

        RadioButton rpsGame = ButtonFactor.radioButtonTimesNewRoman16("Rock - Paper - Scissors", true);
        RadioButton rpslsGame = ButtonFactor.radioButtonTimesNewRoman16("Rock - Paper - Scissors - Lizard -Spock", false);

        rpsGame.setToggleGroup(gameVersionOption);
        rpslsGame.setToggleGroup(gameVersionOption);

        rpsGame.setOnAction(action -> {
            if (rpsGame.isSelected()) {
                this.gameVersionNumber = 1;
            } else {
                this.gameVersionNumber = 2;
            }
        });

        rpslsGame.setOnAction(action -> {
            if (rpslsGame.isSelected()) {
                this.gameVersionNumber = 2;
            } else {
                this.gameVersionNumber = 1;
            }
        });

        this.getChildren().addAll(gameVersion, rpsGame, rpslsGame);

        Text selectedPlayer = TextFactor.textDisplayTimesNewRoman16("What is your name? ");
        TextField firstPlayerName = TextFactor.textFieldName("Player 1");

        Text opponentPlayer = TextFactor.textDisplayTimesNewRoman16("With whom do you want play?");

        ToggleGroup selectOpponentPlayer = new ToggleGroup();

        RadioButton computerPlayer = ButtonFactor.radioButtonTimesNewRoman16("computer", true);
        RadioButton realPlayer = ButtonFactor.radioButtonTimesNewRoman16("real player", false);

        computerPlayer.setToggleGroup(selectOpponentPlayer);
        realPlayer.setToggleGroup(selectOpponentPlayer);

        TextField secondPlayerName = TextFactor.textFieldName("Computer");
        secondPlayerName.setDisable(true);

        computerPlayer.setOnAction(action -> {
            if (computerPlayer.isSelected()) {
                secondPlayerName.setDisable(true);
            } else {
                secondPlayerName.setDisable(false);
            }
        });

        realPlayer.setOnAction(action -> {
            if (realPlayer.isSelected()) {
                secondPlayerName.setDisable(false);
            } else {
                secondPlayerName.setDisable(true);
            }
        });

        this.getChildren().addAll(selectedPlayer, firstPlayerName, opponentPlayer, computerPlayer, realPlayer, secondPlayerName);

        Text howManyGames = TextFactor.textDisplayTimesNewRoman16("How many games is needed to win? " +
                "\nYou can choose from 1 to 10");
        Slider numberOfGames = ButtonFactor.numberOfGame(10);

        this.getChildren().addAll(howManyGames, numberOfGames);

        HBox endingButtonBox = new HBox();

        endingButtonBox.setAlignment(Pos.CENTER);
        endingButtonBox.setSpacing(20);

        Button start = ButtonFactor.optionsButton("START GAME");
        Button close = ButtonFactor.optionsButton("CLOSE");

        start.setOnAction(action -> {
            log.info("Game version " + gameVersionNumber);
            log.info("First player name " + firstPlayerName.getText());
            log.info("Second player name " + secondPlayerName.getText());
            log.info("Number of game " + numberOfGames.getValue());

            Player first = new RealPlayer(firstPlayerName.getText());
            first.setMoveNow(true);

            Player second;

            if (realPlayer.isSelected()) {
                 second = new RealPlayer(secondPlayerName.getText());
            } else {
                second = new ComputerPlayer();
            }

            RPSGame game = new RPSGame(first, second, gameVersionNumber, (int) numberOfGames.getValue());

            if (1 == gameVersionNumber) {
                mainStage.setScene(new Scene(new RPSWindow(game, mainStage)));
            } else {
                mainStage.setScene(new Scene(new RPSLSWindow(game, mainStage)));
            }
        });

        close.setOnAction(action -> {
            mainStage.close();
        });

        endingButtonBox.getChildren().addAll(start, close);
        this.getChildren().addAll(endingButtonBox);
    }
}
