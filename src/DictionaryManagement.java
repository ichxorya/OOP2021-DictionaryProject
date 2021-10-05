import java.io.*;
import java.util.Scanner;

/**
 * DictionaryManagement class.
 *
 * Features:
 * - TOO LAZY TO UPDATE LM*O.
 *
 * (More features (not bugs) will be implemented in the near future).
 */

public class DictionaryManagement {

    //-----------------------------------------------------------------------------------------------------------------------------//

    Character dictionary = new Character(' ', "");      // Init the dictionary.
    int numberOfWords = 0;                                              // Number of words in dictionary.

    //-----------------------------------------------------------------------------------------------------------------------------//

    /**
     * Insert from Command Line.
     */

    void insertFromCommandline() {
        /* Variables */
        Scanner sc = new Scanner(System.in);    // Using scanner to receive user inputs.
        numberOfWords = -1;
        String wordEng;
        String wordVie;

        /* Input */
        while (numberOfWords <= 0) {
            System.out.println("How many words are there?");
            System.out.print("(Input a positive number): ");
            numberOfWords = sc.nextInt();    // After using sc.nextInt(), we have to flush (?) the input stream
        }
        // Flushed!
        String autoFlush = sc.nextLine();   // Important variable meow~~

        while (numberOfWords > 0) {
            System.out.println("Input the English word and its Vietnamese translation: ");
            wordEng = sc.nextLine();
            wordVie = sc.nextLine();

            /* Non-empty check */
            while (wordEng.equals("")) {
                System.out.println("<!> Re-input the English word <!>");
                wordEng = sc.nextLine();
            }
            while (wordVie.equals("")) {
                System.out.println("<!> Re-input the Vietnamese translation <!>");
                wordVie = sc.nextLine();
            }

            /* Added to the dictionary */
            dictionary.addWord(wordEng, wordVie);

            --numberOfWords; // Reduce the number of Word in the queue by 1
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /* Insert From File */
    void insertFromFile() {
        Scanner sc;    // Using scanner to receive data from external file.
        Scanner parser;    // Using scanner to parse strings from external file.
        String wordEng;
        String wordVie;
        String readLine;

        try {
            // Open file
            File dictionaryFile = new File("src/dictionaries.txt");

            // Number of Lines in file = Number of Words
            numberOfWords = DictionaryUtilities.numberOfLines(dictionaryFile);

            // Read file
            sc = new Scanner(dictionaryFile);

            // Imply that the input file is P E R F E C T
            while (sc.hasNextLine()) {
                readLine = sc.nextLine();
                parser = new Scanner(readLine);
                parser.useDelimiter("\t");

                wordEng = parser.next();
                wordVie = parser.next();

                //input
                dictionary.addWord(wordEng, wordVie);
            }

            // Close file (automated???)
        } catch (IOException e) {
            System.out.println("<!> Make sure you have dictionaries.txt in the src folder <!>");
            // e.printStackTrace();  for debugging
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Run if the user want to search for a word or search from a part.
     */
    void searchFromCommandLine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to search for a word or search from a part? 'w' for word and 'p' for part: ");
        if (sc.nextLine().equals("w")) {
            System.out.println("Please write the word you want to search: ");
            dictionaryLookUp(sc.nextLine());
        } else {
            System.out.println("Please write the part you want to search: ");
            dictionarySearcher(sc.nextLine());
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Print all words to the Command Line Interface in order.
     */
    void showAllWords() {
        /* Message's length:012345678901234567890123456789 */
        System.out.println("NO   | English    | Vietnamese");
        /* Print out the English word and its Vietnamese translation */
        int a = dictionary.printAll("", 0, 0);
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Print all the word with the beginning is part and meaning.
     */
    void dictionarySearcher(String part) {
        Character fWord = dictionary.searchPart(part);
        if (fWord.getCharacter() == dictionary.getCharacter()) {
            System.out.println("No word found!");
        } else {
            System.out.println("Word have the same past you are searching for");
            System.out.println("NO   | English    | Vietnamese");
            fWord.printAll(part.substring(0, part.length() - 1), 0, 0);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Print the word user want and meaning.
     */
    void dictionaryLookUp(String word) {
        String pWord = dictionary.searchWord(word);
        if (pWord.equals("No word found!")) {
            System.out.println(pWord);
        } else {
            System.out.println("The word you are searching for: ");
            System.out.println(word  + " has the meaning: " + pWord);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//
}
