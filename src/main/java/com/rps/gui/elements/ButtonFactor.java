package com.rps.gui.elements;

import com.rps.game.Symbol;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class ButtonFactor {
    private static Font fontType = Font.font("Times New Roman", 16);

    public static RadioButton radioButtonTimesNewRoman16 (String text, boolean isSelected) {
        RadioButton button = new RadioButton(text);

        button.setFont(fontType);
        button.setTextFill(Color.BLACK);
        button.setSelected(isSelected);
        button.setMaxHeight(10);

        return button;
    }

    public static Slider numberOfGame(int maxValue) {
        Slider slider = new Slider();

        slider.setMin(1);
        slider.setMax(maxValue);
        slider.setValue(1);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        slider.setBlockIncrement(1);
        slider.valueProperty().addListener((obs, oldVal, newVal) ->
                slider.setValue(newVal.intValue()));

        return slider;
    }

    public static ButtonSymbol symbolButton (Symbol symbol) {
        ButtonSymbol button = new ButtonSymbol(symbol);

        button.setStyle(
                "-fx-background-radius: 175px; " +
                "-fx-min-width: 175px; " +
                "-fx-min-height: 175px; " +
                "-fx-max-width: 175px; " +
                "-fx-max-height: 175px; " +
                "-fx-border-color: transparent; " +
                "-fx-border-width: 0; " +
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 0; "
        );

        return button;
    }

    public static Button optionsButton(String text) {
        Button button = new Button(text);

        button.setStyle(
                "-fx-background-size: 100px; " +
                "-fx-min-height: 50px; " +
                "-fx-max-height: 50px; " +
                "-fx-alignment: center;" +
                "-fx-background-color: darkgray; " +
                "-fx-font-family: 'Times New Roman';" +
                "-fx-font-size: 16px;" +
                "-fx-font-smoothing-type: gray;"
        );

        return button;
    }


}
