package com.rps.gui.elements;

import com.rps.game.Symbol;
import javafx.scene.control.Button;

public class ButtonSymbol extends Button {

    private final Symbol symbol;

    public ButtonSymbol(Symbol symbol) {
        super();
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
