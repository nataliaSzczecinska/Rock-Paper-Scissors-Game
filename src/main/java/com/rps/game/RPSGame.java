package com.rps.game;

public class RPSGame extends RPSRules {

    private final Statistic statistic;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final int gameVersion;

    public RPSGame(Player firstPlayer, Player secondPlayer, int gameVersion, int numberOfGameToWin) {
        super();
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.gameVersion = gameVersion;
        this.statistic = new Statistic(numberOfGameToWin);
    }

    public boolean checkResult() {
        if (statistic.getNumberOfGameToWin() == statistic.getFirstPlayerWin() ||
        statistic.getNumberOfGameToWin() == statistic.getSecondPlayerWin()) {
            return true;
        }
        return false;
    }

    public int whoWinNumber() {
        return this.whoWinTab[firstPlayer.getMove().getNumber() - 1][secondPlayer.getMove().getNumber() - 1];
    }

    public int whoWin() {
        switch (whoWinNumber()) {
            case 0: {
                log.info("There is a draw");
                statistic.addGameRounds();
                statistic.addDraws();
                break;
            } case 1: {
                log.info("The first player win");
                statistic.addFirstPlayerWin();
                statistic.addGameRounds();
                break;
            } case -1: {
                log.info("The second player win");
                statistic.addSecondPlayerWin();
                statistic.addGameRounds();
                break;
            } default: {
                log.warning("The winTab do not give correct number");
            }
        }
        currentStatisticDisplay();

        return whoWinNumber();
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public int getGameVersion() {
        return gameVersion;
    }

    public void currentStatisticDisplay() {
        log.info("Current statistic " +
                "\nrounds: " + statistic.getGameRounds() +
                "\nfirst player wins: " + statistic.getFirstPlayerWin() +
                "\nsecond player wins: " + statistic.getSecondPlayerWin() +
                "\ndraws: " + statistic.getDraws());
    }
}
