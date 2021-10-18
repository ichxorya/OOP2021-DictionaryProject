package com.example.tree_dictionary_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    DictionaryManagement dictionary = new DictionaryManagement();

    @FXML
    private TextField in = new TextField();

    @FXML
    private TextField out = new TextField();

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void Testbutton() {
        welcomeText.setText("Welcome to Application!");
    }

    @FXML
    protected void printText() {
        String a = in.getText();
        out.setText(dictionary.dictionaryLookupMean(a));
    }

}