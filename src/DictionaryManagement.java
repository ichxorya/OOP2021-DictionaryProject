import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {

    /**
     * DictionaryManagement class - To insert new words to the dictionary from the CLI (command line interface).
     * More features (not bugs) will be implemented in the near future.
     */

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
     * This method do following action:
     * - 'sw': Search for a word.
     * - 'sp': Search words have beginning part.
     * - 'd' : Delete a word.
     * - 'm' : Modify meaning of a word.
     * - 'w' : Modify a word with given meaning.
     *
     * Trying to make this repeatable but not working. Try to fix it N, OK_^_
     */
    void optionFromCommandLine() {
        Scanner sc = new Scanner(System.in);

        boolean next = true;
        while (next) {
            System.out.println("Option to do:");
            System.out.println("  - 'sw': Search for a word.");
            System.out.println("  - 'sp': Search words have beginning part.");
            System.out.println("  - 'd' : Delete a word.");
            System.out.println("  - 'm' : Modify meaning of a word.");
            System.out.println("  - 'w' : Modify a word with given meaning.");
            System.out.println("What do you want to do: ");

            switch (sc.nextLine()) {
                case "sw":
                    System.out.println("Please write the word you want to search: ");
                    dictionaryLookedUp(sc.nextLine());
                    break;
                case "sp":
                    System.out.println("Please write the part you want to search: ");
                    dictionarySearcher(sc.nextLine());
                    break;
                case "d":
                    System.out.println("Please write the word you want to delete: ");
                    dictionaryDelete(sc.nextLine());
                    break;
                case "m":
                    System.out.println("Please write the word and new meaning you want to modify meaning: ");
                    dictionaryModMean(sc.nextLine(), sc.nextLine());
                    break;
                case "w":
                    System.out.println("Please write the word and new word you want to modify: ");
                    dictionaryModWord(sc.nextLine(), sc.nextLine());
                    break;
            }

            System.out.println("Do you want to quit or do other option?");
            System.out.println("any key to quit or 'y' to continue:");
            if (sc.nextLine() == "y") {
                continue;
            }
            next = false;
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
     * Print all the word with the beginning is part and meaning.
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
     * Print the word user want and meaning.
     */
    void dictionaryLookedUp(String word) {
        String pWord = dictionary.searchWord(word);
        if (pWord == "We can't find it!") {
            System.out.println(pWord);
        } else {
            System.out.println("The word you are searching for: ");
            System.out.println(word  + " has the meaning: " + pWord);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Celete the given word.
     */
    void dictionaryDelete(String word) {
        System.out.println(dictionary.deleteWord(word));
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Replace meaning of the given word.
     */
    void dictionaryModMean(String word, String newMean) {
        String mean = dictionary.changeMean(word, newMean);
        if (mean != "We can't find it!") {
            System.out.println(word + " has new mean: " + mean);
        } else {
            System.out.println(mean);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Replace the word but keep meaning.
     */
    void dictionaryModWord(String word, String newWord) {
        String mean = dictionary.searchWord(word);
        if (mean == "No word found!") {
            System.out.println(mean);
        } else {
            dictionary.deleteWord(word);
            dictionary.addWord(newWord, mean);
            System.out.println(word + " has bean change to " + newWord);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

}
