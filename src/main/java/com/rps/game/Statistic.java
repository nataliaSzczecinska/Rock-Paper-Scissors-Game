package com.rps.game;

public class Statistic {

    private final int numberOfGameToWin;
    private int firstPlayerWin;
    private int secondPlayerWin;
    private int gameRounds;
    private int draws;

    public Statistic(int numberOfGameToWin) {
        this.numberOfGameToWin = numberOfGameToWin;
        this.firstPlayerWin = 0;
        this.secondPlayerWin = 0;
        this.gameRounds = 0;
        this.draws = 0;
    }

    public int getFirstPlayerWin() {
        return firstPlayerWin;
    }

    public void addFirstPlayerWin() {
        this.firstPlayerWin++;
    }

    public int getSecondPlayerWin() {
        return secondPlayerWin;
    }

    public void addSecondPlayerWin() {
        this.secondPlayerWin++;
    }

    public int getGameRounds() {
        return gameRounds;
    }

    public void addGameRounds() {
        this.gameRounds++;
    }

    public void addDraws() {
        this.draws++;
    }

    public int getDraws() {
        return draws;
    }

    public int getNumberOfGameToWin() {
        return numberOfGameToWin;
    }

    public void clearStatistic() {
        this.firstPlayerWin = 0;
        this.secondPlayerWin = 0;
        this.gameRounds = 0;
        this.draws = 0;
    }
}
