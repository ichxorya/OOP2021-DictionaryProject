import java.io.*;
import java.util.Scanner;

/**
 * DictionaryManagement class.
 *
 * To insert new words to the dictionary from the CLI (Command Line Interface).
 * (More features (not bugs) will be implemented in the near future).
 */

public class DictionaryManagement {

    //-----------------------------------------------------------------------------------------------------------------------------//

    Character dictionary = new Character(' ', "");      // init the dictionary.
    int numberOfWords = 0;                                              // number of words in dictionary.

    //-----------------------------------------------------------------------------------------------------------------------------//

    /* Insert From Command Line */
    void insertFromCommandline() {
        /* Variables */
        Scanner sc = new Scanner(System.in);    // Using scanner to receive user inputs.
        numberOfWords = -1;
        int dictIndex = 0;
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

            /* Added to the WHAT??? */
            dictionary.addWord(wordEng, wordVie);

            ++dictIndex;    // Increase the index of the Word array
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
            numberOfWords = HelperMethod.numberOfLines(dictionaryFile);

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
     * Run if user want to search a word or search from a part.
     */
    void searchFromCommandLine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to search a word or search from a part? 'w' for word and 'p' for part: ");
        if (sc.nextLine() == "w") {
            System.out.println("Please write the word you want to search: ");
            dictionaryLookedUp(sc.nextLine());
        } else {
            System.out.println("Please write the part you want to search: ");
            dictionarySearcher(sc.nextLine());
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Method print all word to cmd in order.
     */
    void showAllWords() {
        /* Message's length:012345678901234567890123456789*/
        System.out.println("NO   | English    | Vietnamese");
        /* Print out the English word and its Vietnamese translation */
        int a = dictionary.printAll("", 0, 0);
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * print all the word with the beginning is part and meaning.
     */
    void dictionarySearcher(String part) {
        Character fWord = dictionary.searchPart(part);
        if (fWord.getCharacter() == dictionary.getCharacter()) {
            System.out.println("No word found!");
        } else {
            System.out.println("Word have the same past you are searching for");
            System.out.println("NO   | English    | Vietnamese");
            fWord.printAll(part.substring(0,part.length() - 1), 0, 0);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * print the word user want and meaning.
     */
    void dictionaryLookedUp(String word) {
        String pWord = dictionary.searchWord(word);
        if (pWord == "No word found!") {
            System.out.println(pWord);
        } else {
            System.out.println("The word you are searching for: ");
            System.out.println(word  + " has the meaning: " + pWord);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//
}
