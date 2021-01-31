package com.rps.game;

import java.util.logging.Logger;

public class RealPlayer implements Player {

    protected final Logger log = Logger.getLogger(getClass().getName());
    private final String name;

    private boolean isMoveNow;
    private Symbol chosenSymbol;

    public RealPlayer(String name) {
        this.name = name;
    }

    @Override
    public Symbol getMove() {
        return chosenSymbol;
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
        this.chosenSymbol = symbol;
    }
}
