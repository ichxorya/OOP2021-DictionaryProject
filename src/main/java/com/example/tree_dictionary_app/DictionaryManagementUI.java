package com.example.tree_dictionary_app;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryManagementUI {

    //-----------------------------------------------------------------------------------------------------------------------------//

    DictChar dictionaryEng = new DictChar(' ', "");      // init the Eng -> Vie dictionary.
    DictChar dictionaryVie = new DictChar(' ', "");      // init the Vie -> Eng dictionary.

    //-----------------------------------------------------------------------------------------------------------------------------//

    DictionaryManagementUI() {
        insertFromFile();
    }

    /**
     * return meaning of the word user want.
     */
    String dictionaryLookup(String word, DictChar dictionary) {
        return dictionary.searchWord(word);
    }

    //-----------------------------------------------------------------------------------------------------------------------------//

    /**
     * Print all the word with the beginning is part and meaning.
     */
    String dictionarySearcherIn(String part, DictChar dictionary) {
        DictChar fWord = dictionary.searchPart(part);
        if (fWord.getCharacter() == dictionary.getCharacter()) {
           return "No word found!";
        } else {
            return fWord.printAllWord(part.substring(0,part.length() - 1), "");
        }
    }

    String dictionarySearcherOut(String part, DictChar dictionary) {
        DictChar fWord = dictionary.searchPart(part);
        if (fWord.getCharacter() == dictionary.getCharacter()) {
            return "No word found!";
        } else {
            return fWord.printAllMean(part.substring(0,part.length() - 1), "");
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------//

    /**
     * Insert from file.
     */
    void insertFromFile() {
        Scanner sc;    // Using scanner to receive data from external file.
        Scanner parser;    // Using scanner to parse strings from external file.
        String wordEng;
        String wordVie;
        String readLine;

        try {
            // Open file
            FileReader dictionaryFile = new FileReader("src\\dictionaries.txt");

            // Read file
            sc = new Scanner(dictionaryFile);

            // Imply that the input file is P E R F E C T
            while (sc.hasNextLine()) {
                readLine = sc.nextLine();
                parser = new Scanner(readLine);
                parser.useDelimiter("\t");

                wordEng = parser.next();
                wordVie = parser.next();

                //Input
                dictionaryEng.addWord(wordEng, wordVie);
                dictionaryVie.addWord(wordVie, wordEng);
            }
        } catch (IOException e) {
            System.out.println("<!> Make sure you have dictionaries.txt in the src folder <!>");
            // e.printStackTrace();  for debugging
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------//
}
