package uet.oop.ourtreedictionary;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Collections;
import java.util.Scanner;

/**
 * DictionaryUtilities class.
 *
 * Contains utility methods for other classes.
 */

public class DictionaryUtilities {

    //----------------------------------------------------------------------------------------------------------------//

    /**
     * Reformat the output strings then print them out.
     *
     * Example:
     * NO   | English    | Vietnamese
     * 1    | Pig        | Lợn
     * 2    | Uncle      | Chú
     * 3    | Zoo        | Vườn thú
     */
    static void formatStringAndPrint(int index, String firstWord, String secondWord) {
        /* Space-padding */
        String indexStr = index + "";
        firstWord = "|" + firstWord;
        secondWord = "| " + secondWord;

        indexStr = String.format("%" + 5 + "s", indexStr);
        firstWord = String.format("%" + (-13) + "s", firstWord);
        System.out.println(indexStr + firstWord + secondWord);
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

    //----------------------------------------------------------------------------------------------------------------//

    /**
     * Insert from file (Utility method).
     */
    static void insertFromFileUtils(DictChar dictionaryEng, DictChar dictionaryVie) {
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
            System.out.println("Imported from file!");
        } catch (IOException e) {
            System.out.println("<!> Make sure you have dictionaries.txt in the src folder <!>");
            // e.printStackTrace();  for debugging
        }
    }

    //----------------------------------------------------------------------------------------------------------------//

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

    //----------------------------------------------------------------------------------------------------------------//

    static String standardize(String s) {
        if (s.length() == 1) {
            return s.toUpperCase();
        } else {
            return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        }
    }

    //----------------------------------------------------------------------------------------------------------------//
}

