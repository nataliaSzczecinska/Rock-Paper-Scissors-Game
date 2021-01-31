package com.rps.game;

import java.util.logging.Logger;
import java.util.*;

public class ComputerPlayer implements Player {

    protected final Logger log = Logger.getLogger(getClass().getName());
    private final String name = "Computer";

    private Symbol symbol;
    private boolean isMoveNow;

    @Override
    public Symbol getMove() {
        Random random = new Random();

        int choice = random.nextInt(5) + 1;

        switch (choice) {
            case 1: {
                return Symbol.ROCK;
            } case 2: {
                return Symbol.PAPER;
            } case 3: {
                return Symbol.SCISSORS;
            } case 4: {
                return Symbol.LIZARD;
            } case  5: {
                return Symbol.SPOCK;
            } default: {
                log.warning("The chosen symbol is not exist");
                return null;
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isMoveNow() {
        return isMoveNow;
    }

    @Override
    public void setMoveNow(boolean term) {
        this.isMoveNow = term;
    }

    @Override
    public void setMove(Symbol symbol) {
        this.symbol = getMove();
    }
}
