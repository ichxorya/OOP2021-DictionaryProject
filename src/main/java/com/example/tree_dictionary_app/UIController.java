package com.example.tree_dictionary_app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class UIController {

    DictionaryManagementUI dictionary = new DictionaryManagementUI();

    //-----------------------------------------------------------------------------------------------------------------------------//

    /**
     * Search word panel.
     */

    @FXML
    private TextField engFieldWord = new TextField();       // English word field.

    @FXML
    private TextField vieFieldWord = new TextField();       // Vietnamese word field.

    /**
     * Translate when button is pressed.
     */
    @FXML
    protected void searchWord() {
        String wordEn = engFieldWord.getText();
        String wordVi = vieFieldWord.getText();
        if (!wordEn.equals("") && wordVi.equals("")) {
            vieFieldWord.setText(dictionary.dictionaryLookup(wordEn, dictionary.dictionaryEng));
        } else if (wordEn.equals("") && !wordVi.equals("")) {
            engFieldWord.setText(dictionary.dictionaryLookup(wordVi, dictionary.dictionaryVie));
        } else {
            engFieldWord.setText("");
            vieFieldWord.setText("");
        }
    }

    /**
     * Clear other field when this field's text change.
     */
    @FXML
    protected void clearWEngWord() {
        engFieldWord.setText("");
    }

    @FXML
    protected void clearVieWord() {
        vieFieldWord.setText("");
    }

    //----------------------------------------------------------------------------------------------------------------//

    /**
     * Search part panel.
     */

    @FXML
    private TextField engFieldPart = new TextField();           // English input word field.

    @FXML
    private TextField vieFieldPart = new TextField();           // Vietnamese input word field.

    @FXML
    private TextArea engAreaPart = new TextArea();              // English output word field.

    @FXML
    private TextArea vieAreaPart = new TextArea();              // Vietnamese output word field.

    /**
     * Search all English words that have the part and its meaning.
     */
    @FXML
    protected void searchPartEng() {
        String word = engFieldPart.getText();
        if (word.equals("")) {
            engAreaPart.setText("");
            vieAreaPart.setText("");
        } else {
            vieFieldPart.setText("");
            engAreaPart.setText(dictionary.dictionarySearcherIn(word, dictionary.dictionaryEng));
            vieAreaPart.setText(dictionary.dictionarySearcherOut(word, dictionary.dictionaryEng));
        }
    }

    /**
     * Search all Vietnamese words that have the part and its meaning.
     */
    @FXML
    protected void searchPartVie() {
        String word = vieFieldPart.getText();
        if (word.equals("")) {
            engAreaPart.setText("");
            vieAreaPart.setText("");
        } else {
            engFieldPart.setText("");
            vieAreaPart.setText(dictionary.dictionarySearcherIn(word, dictionary.dictionaryVie));
            engAreaPart.setText(dictionary.dictionarySearcherOut(word, dictionary.dictionaryVie));
        }
    }

    //----------------------------------------------------------------------------------------------------------------//

    /**
     * Add word.
     */

    @FXML
    private TextField addWordEng = new TextField();                 // English input word field.

    @FXML
    private TextField addWordVie = new TextField();                 // Vietnamese input word field.

    @FXML
    private Label isAddDone = new Label();                          // Label return system respond action success or not

    /**
     * Add a pair of English and Vietnamese word to dictionary.
     */
    @FXML
    protected void addWord() {
        dictionary.addWord(addWordEng.getText(), addWordVie.getText());
        isAddDone.setText("Done");
    }

                    //---------------------------------//

    /**
     * Delete word.
     */

    @FXML
    private TextField deleteWordEng = new TextField();              // English input word field.

    @FXML
    private TextField deleteWordVie = new TextField();              // Vietnamese input word field.

    @FXML
    private Label isDelDone = new Label();                          // Label return system respond action success or not

    /**
     * Delete a pair of English and Vietnamese word to dictionary.
     */
    @FXML
    protected void deleteWord() {
        String wEng = deleteWordEng.getText();
        String wVie = deleteWordVie.getText();
        if (!wEng.equals("") && wVie.equals("")) {
            isDelDone.setText(dictionary.deleteWord(wEng, dictionary.dictionaryEng));
        } else if (wEng.equals("") && !wVie.equals("")) {
            isDelDone.setText(dictionary.deleteWord(wVie, dictionary.dictionaryVie));
        } else {
            isDelDone.setText("Delete an English or a Vietnamese word at one time");
        }
    }

                    //---------------------------------//

    /**
     * Toggle stuff support below action.
     */

    @FXML
    private ToggleButton togEng = new ToggleButton();

    @FXML
    private ToggleButton togVie = new ToggleButton();

    /**
     * Make a English/Vietnamese switch.
     */
    @FXML
    protected void toggleReady() {
        togEng.setSelected(true);
        togVie.setSelected(false);
    }

    @FXML
    protected void setTogEng() {
        togVie.setSelected(!togEng.isSelected());
    }

    @FXML
    protected void setTogVie() {
        togEng.setSelected(!togVie.isSelected());
    }

                    //---------------------------------//

    @FXML
    private TextField modWordOld = new TextField();                 // old word input field.

    @FXML
    private TextField modWordNew = new TextField();                 // new word input field.

    @FXML
    private Label isModWordDone = new Label();                      // Label return system respond action success or not

    /**
     * Modify the oldword to new one but keep it meaning.
     */
    @FXML
    protected void modifyWord() {
        if (togEng.isSelected()) {
            isModWordDone.setText(
                    dictionary.dictionaryModWord(
                            modWordOld.getText(), modWordNew.getText(), dictionary.dictionaryEng));
        } else {
            isModWordDone.setText(
                    dictionary.dictionaryModWord(
                            modWordOld.getText(), modWordNew.getText(), dictionary.dictionaryVie));
        }
    }

                    //---------------------------------//

    @FXML
    private TextField modMeanOld = new TextField();                 // the modified word input field.

    @FXML
    private TextField modMeanNew = new TextField();                 // new meaning input field.

    @FXML
    private Label isModMeanDone = new Label();                      // Label return system respond action success or not

    /**
     * Modify the meaning of word to new one.
     */
    @FXML
    protected void modifyMeaning() {
        if (togEng.isSelected()) {
            isModMeanDone.setText(
                    dictionary.dictionaryModMeaning(
                            modMeanOld.getText(), modMeanNew.getText(), dictionary.dictionaryEng));
        } else {
            isModMeanDone.setText(
                    dictionary.dictionaryModMeaning(
                            modMeanOld.getText(), modMeanNew.getText(), dictionary.dictionaryVie));
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------//

    @FXML
    private Label isExported = new Label();                         // Label return system respond action success or not

    /**
     * Export all words to file
     */
    @FXML
    protected void exportToFile() {
        dictionary.dictionaryExportToFile();
        isExported.setText("Done");
    }

    /**
     * Re-import words.
     */
    @FXML
    protected void importFromFile() {
        dictionary.insertFromFile();
        isExported.setText("Done");
    }

    //-----------------------------------------------------------------------------------------------------------------------------//
}