package com.rps.gui.elements;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TextFactor {

    public static Text textDisplayArial20WithUnderline(String text){
        Text displayText = new Text();
        displayText.setFont(Font.font ("Arial", FontWeight.BOLD, 20));
        displayText.setFill(Color.WHITE);
        displayText.setText(text);
        displayText.setUnderline(true);
        displayText.setTextAlignment(TextAlignment.CENTER);

        return displayText;
    }

    public static Text textDisplayArial18(String text){
        Text displayText = new Text();
        displayText.setFill(Color.WHITE);
        displayText.setFont(Font.font ("Arial", 18));
        displayText.setText(text);
        displayText.setTextAlignment(TextAlignment.CENTER);

        return displayText;
    }

    public static Text textDisplayArial18Black(String text){
        Text displayText = textDisplayArial18(text);
        displayText.setFill(Color.BLACK);

        return displayText;
    }

    public static Text textDisplayArial16(String text){
        Text displayText = new Text();
        displayText.setFill(Color.WHITE);
        displayText.setFont(Font.font ("Arial", 16));
        displayText.setText(text);
        displayText.setTextAlignment(TextAlignment.CENTER);

        return displayText;
    }

    public static Text textDisplayTimesNewRoman16(String text){

        Text displayText = new Text();
        displayText.setFill(Color.BLACK);
        displayText.setFont(Font.font ("Times New Roman", 16));
        displayText.setText(text);
        displayText.setTextAlignment(TextAlignment.CENTER);

        return displayText;
    }

    public static Text textDisplayTimesNewRoman12(String text){

        Text displayText = textDisplayTimesNewRoman16(text);
        displayText.setFont(Font.font ("Times New Roman", 12));

        return displayText;
    }

    public static TextField textFieldName(String text) {
        TextField textField = new TextField(text);

        textField.setAlignment(Pos.CENTER);
        textField.setPrefColumnCount(200);

        return textField;
    }
}
