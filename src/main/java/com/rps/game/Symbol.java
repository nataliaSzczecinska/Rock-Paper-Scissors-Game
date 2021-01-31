package com.rps.game;

public enum Symbol {
    ROCK (1, "Rock"),
    PAPER (2, "Paper"),
    SCISSORS (3, "Scissors"),
    LIZARD(4, "Lizard"),
    SPOCK(5, "Spock");

    private int number;
    private String name;

    Symbol(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
