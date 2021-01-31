package com.rps.gui;

import com.rps.game.*;
import com.rps.gui.elements.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.logging.Logger;

public abstract class GameWindow extends HBox {
    protected final Logger log = Logger.getLogger(getClass().getName());

    protected static final double OPTIMUM_HIGH = 600;
    protected static final double OPTIMUM_WIDTH = 1000;
    protected final RPSGame game;
    protected final Stage mainStage;
    private String title;

    protected GameWindow(RPSGame game, Stage mainStage, String title) {
        super();
        this.game = game;
        this.mainStage = mainStage;
        this.title = title;

        mainStage.setWidth(OPTIMUM_WIDTH);
        mainStage.setHeight(OPTIMUM_HIGH);
        mainStage.setResizable(false);
        mainStage.setTitle(title);
        mainStage.centerOnScreen();

        this.setBackground(BackgroundFactor.entryWindow());
    }

    protected VBox gameResultDisplayVBox() {
        VBox vBox = new VBox();

        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        Text theGame = TextFactor.textDisplayArial18Black(title);
        Text currentPlayer = TextFactor.textDisplayTimesNewRoman12("The current player: ");
        Text currentPlayerName;

        if (game.getFirstPlayer().isMoveNow()) {
            currentPlayerName = TextFactor.textDisplayTimesNewRoman12(game.getFirstPlayer().getName());
        } else {
            currentPlayerName = TextFactor.textDisplayTimesNewRoman12(game.getSecondPlayer().getName());
        }

        Text lastRoundWinner = currentWinnerDisplay();

        Text currentStatistic = TextFactor.textDisplayTimesNewRoman12("The statistic of game");
        Text currentRound = TextFactor.textDisplayTimesNewRoman12("Current round: " + game.getStatistic().getGameRounds());
        Text currentFirstWin = TextFactor.textDisplayTimesNewRoman12("Current " + game.getFirstPlayer().getName() + " win(s): " + game.getStatistic().getFirstPlayerWin());
        Text currentSecondWin = TextFactor.textDisplayTimesNewRoman12("Current " + game.getSecondPlayer().getName() + " win(s): " + game.getStatistic().getSecondPlayerWin());
        Text currentDraws = TextFactor.textDisplayTimesNewRoman12("Current draws: " + game.getStatistic().getDraws());

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        Button playAgain = ButtonFactor.optionsButton("PLAY AGAIN");
        Button close = ButtonFactor.optionsButton("CLOSE");

        playAgain.setOnAction(action -> {
            log.info("play again");
            game.getStatistic().clearStatistic();
            refresh();
        });

        close.setOnAction(action -> {
            log.info("close");
            mainStage.close();
        });

        hBox.getChildren().addAll(playAgain, close);

        vBox.getChildren().addAll(theGame, currentPlayer, currentPlayerName, lastRoundWinner,
                currentStatistic, currentRound, currentFirstWin, currentSecondWin, currentDraws, hBox);

        return vBox;
    }

    private Text currentWinnerDisplay () {
        String text = "The last round winner is ";
        if (0  != game.getStatistic().getGameRounds()) {
            switch (game.whoWinNumber()) {
                case 0: {
                    return TextFactor.textDisplayTimesNewRoman12(text + "no one, the last game finished draw");
                }
                case 1: {
                    return TextFactor.textDisplayTimesNewRoman12(text + game.getFirstPlayer().getName());
                }
                case -1: {
                    return TextFactor.textDisplayTimesNewRoman12(text + game.getSecondPlayer().getName());
                }
                default: {
                    log.warning("The winTab do not give correct number");
                    return null;
                }
            }
        }
        return TextFactor.textDisplayTimesNewRoman12(text + "no one, the game has just stared");
    }

    protected void refresh() {
        Scene refreshScene;
        if (1 == game.getGameVersion()) {
            refreshScene = new Scene(new RPSWindow(game, mainStage));
        } else {
            refreshScene = new Scene(new RPSLSWindow(game, mainStage));
        }
        mainStage.setScene(refreshScene);
    }

    private void move(Player play, Player wait, Symbol symbol) {
        play.setMove(symbol);
        log.info("The " + play.getName() +
                " move. The chosen symbol: " + play.getMove());
        play.setMoveNow(false);
        wait.setMoveNow(true);
    }

    private void action(Symbol symbol) {
        if (game.getFirstPlayer().isMoveNow()) {
            move(game.getFirstPlayer(), game.getSecondPlayer(), symbol);
            refresh();
            if (ComputerPlayer.class.equals(game.getSecondPlayer().getClass())) {
                move(game.getSecondPlayer(), game.getFirstPlayer(), symbol);
            }
        } else {
            move(game.getSecondPlayer(), game.getFirstPlayer(), symbol);
        }
        game.whoWin();
        refresh();

        if (game.checkResult()) {
            EndGameWindow.displayEndGameWindow(game, mainStage, title);
        }
    }

    protected void setAction(ButtonSymbol [] symbols) {
        for (int i = 0 ; i < symbols.length ; i++) {
            final int I = i;
            symbols[i].setOnAction(action -> {
                log.info("The " + symbols[I].getSymbol() + " is pushed");
                action(symbols[I].getSymbol());
            });
        }
    }
}
