package com.rps.game;

public interface Player {
    public Symbol getMove();
    public String getName();
    public boolean isMoveNow();
    public void setMoveNow(boolean term);
    public void setMove(Symbol symbol);
}
