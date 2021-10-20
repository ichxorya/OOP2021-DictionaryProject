package com.example.tree_dictionary_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    DictionaryManagementUI dictionary = new DictionaryManagementUI();

    @FXML
    private TextField in = new TextField();

    @FXML
    private TextField out = new TextField();

    @FXML
    private TextArea inArea = new TextArea();

    @FXML
    private TextArea outArea = new TextArea();

    @FXML
    protected void searchWord() {
        String word = in.getText();
        out.setText(dictionary.dictionaryLookup(word, dictionary.dictionaryEng));
    }

    @FXML
    protected void searchPartEng() {
        String word = in.getText();
        if (word.equals("")) {
            inArea.setText("");
            outArea.setText("");
        } else {
            inArea.setText(dictionary.dictionarySearcherIn(word, dictionary.dictionaryEng));
            outArea.setText(dictionary.dictionarySearcherOut(word, dictionary.dictionaryEng));
        }
    }

}