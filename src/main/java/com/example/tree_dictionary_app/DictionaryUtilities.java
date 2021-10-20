package com.example.tree_dictionary_app;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Collections;

/**
 * DictionaryUtilities class.
 *
 * Contains utility methods for other classes.
 */

public class DictionaryUtilities {

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Reformat the output strings then print them out.
     *
     * Example:
     * NO   | English    | Vietnamese
     * 1    | Pig        | Lợn
     * 2    | Uncle      | Chú
     * 3    | Zoo        | Vườn thú
     */
    static String formatStringAndPrint(int index, String firstWord, String secondWord) {
        /* Space-padding */
        String indexStr = index + "";
        firstWord = "|" + firstWord;
        secondWord = "| " + secondWord;

        indexStr = String.format("%" + 5 + "s", indexStr);
        firstWord = String.format("%" + (-13) + "s", firstWord);
        return indexStr + firstWord + secondWord;
    }

    /**
     * Reformat the output strings then return them as a new string.
     */
    static String formatStringAndReturn(int index, String firstWord, String secondWord) {
        /* Space-padding */
        String indexStr = index + "";
        firstWord = "|" + firstWord;
        secondWord = "| " + secondWord;

        indexStr = String.format("%" + 5 + "s", indexStr);
        firstWord = String.format("%" + (-13) + "s", firstWord);
        return (indexStr + firstWord + secondWord);
    }

    @Deprecated
    /* Replaced with more efficient method. */
    static void formatStringAndPrint_Old(int index, String firstWord, String secondWord) {
        /* Space-padding */
        String indexStr = index + "";
        firstWord = "| " + firstWord;
        secondWord = "| " + secondWord;
        while (indexStr.length() < 5) {
            indexStr += ' ';
        }
        while ((indexStr + firstWord).length() < 18) {
            firstWord += ' ';
        }
        System.out.println(indexStr + firstWord + secondWord);
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Count the number of lines of a file.
     */
    static int numberOfLines(File file) throws IOException {
        FileReader readFile = new FileReader(file);
        LineNumberReader lineNumberReader = new LineNumberReader(readFile);

        int lineNumber = 0;
        while (lineNumberReader.readLine() != null) {
            lineNumber++;
        }
        return lineNumber;
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Sort the afterChar of DictChar.
     */
    static void ArrSort(DictChar target) {
        if (target.afterChar.size() > 1) {
            for (int i = target.afterChar.size() - 1; i > 0; i--) {
                if (target.afterChar.get(i).getCharacter() < target.afterChar.get(i - 1).getCharacter()) {
                    Collections.swap(target.afterChar, i, i - 1);
                }
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//
}

