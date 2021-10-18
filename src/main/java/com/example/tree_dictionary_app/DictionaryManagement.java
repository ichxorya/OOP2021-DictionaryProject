package com.example.tree_dictionary_app;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * DictionaryManagement class.
 *
 * Features:
 * -Insert words from a text file or command line.
 * -Remove words from the dictionary.
 * -Find words (full/partial).
 * -Modify words/meanings.
 * -Show all words.
 *
 * More features (not bugs) will be implemented in the near future.
 * !!!!!!!!!
 * dictionaryExportToFile()
 * !!!!!!!!
 */

public class DictionaryManagement {

    //-----------------------------------------------------------------------------------------------------------------------------//

    DictChar dictionaryEng = new DictChar(' ', "");      // init the Eng -> Vie dictionary.
    DictChar dictionaryVie = new DictChar(' ', "");      // init the Vie -> Eng dictionary.

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * This method do following action:
     * - 'sw': Search for a word.
     * - 'sp': Search words have beginning part.
     * - 'd' : Delete a word.
     * - 'm' : Modify meaning of a word.
     * - 'w' : Modify a word with given meaning.
     * - 'list' : List all the words in the dictionary.
     * - 'export' : Export the dictionary to a text file.
     * - 'new' : Add new words from command line.
     */
    void optionFromCommandLine() {
        Scanner sc = new Scanner(System.in);

        boolean next = true;
        while (next) {
            System.out.println("Option to do:");
            System.out.println("  - 'swe': Search for an English word.");
            System.out.println("  - 'swv': Search for a Vietnamese word.");
            System.out.println("  - 'spe': Search English words from their beginning part.");
            System.out.println("  - 'spv': Search Vietnamese words from their beginning part.");
            System.out.println("  - 'de' : Delete an English word.");
            System.out.println("  - 'dv' : Delete an Vietnamese word.");
            System.out.println("  - 'me' : Modify the meaning of an English word.");
            System.out.println("  - 'mv' : Modify the meaning of a Vietnamese word.");
            System.out.println("  - 'we' : Modify an English word with given meaning.");
            System.out.println("  - 'wv' : Modify a Vietnamese word with given meaning.");
            System.out.println("  - 'list' : List all the words in the dictionary.");
            System.out.println("  - 'export' : Export the dictionary to a text file.");
            System.out.println("  - 'new' : Add new words from command line.");
            System.out.println("What do you want to do: ");

            switch (sc.nextLine()) {
                case "swe" -> {
                    System.out.println("Please write the word you want to search: ");
                    dictionaryLookup(sc.nextLine(), dictionaryEng);
                }
                case "swv" -> {
                    System.out.println("Please write the word you want to search: ");
                    dictionaryLookup(sc.nextLine(), dictionaryVie);
                }
                case "spe" -> {
                    System.out.println("Please write the part you want to search: ");
                    dictionarySearcher(sc.nextLine(), dictionaryEng);
                }
                case "spv" -> {
                    System.out.println("Please write the part you want to search: ");
                    dictionarySearcher(sc.nextLine(), dictionaryVie);
                }
                case "de" -> {
                    System.out.println("Please write the word you want to delete: ");
                    dictionaryDelete(sc.nextLine(), dictionaryEng);
                }
                case "dv" -> {
                    System.out.println("Please write the word you want to delete: ");
                    dictionaryDelete(sc.nextLine(), dictionaryVie);
                }
                case "me" -> {
                    System.out.println("Please write the word and new meaning you want to modify meaning: ");
                    dictionaryModMeaning(sc.nextLine(), sc.nextLine(), dictionaryEng);
                }
                case "mv" -> {
                    System.out.println("Please write the word and new meaning you want to modify meaning: ");
                    dictionaryModMeaning(sc.nextLine(), sc.nextLine(), dictionaryVie);
                }
                case "we" -> {
                    System.out.println("Please write the word and new word you want to modify: ");
                    dictionaryModWord(sc.nextLine(), sc.nextLine(), dictionaryEng);
                }
                case "wv" -> {
                    System.out.println("Please write the word and new word you want to modify: ");
                    dictionaryModWord(sc.nextLine(), sc.nextLine(), dictionaryVie);
                }
                case "list" -> {
                    showAllWords();
                }
                case "export" -> {
                    try {
                        dictionaryExportToFile();
                    } catch (IOException e) {
                        System.out.println("<!> Can't export to file for some reasons <!>");
//                        e.printStackTrace(); debug
                    }
                }
                case "new" -> {
                    insertFromCommandline();
                }
                default -> {
                    System.out.println("Wrong input. Press any key to continue or 'x' to end this session. ");
                    if (!sc.nextLine().equals("x")) {
                        continue;
                    }
                    next = false;
                }
            }

            if (next) {
                System.out.println("Press any key to quit or 'y' to continue using this Fully Automated Luxury Dictionary:");
                if (sc.nextLine().equals("y")) {
                    continue;
                }
                next = false;
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Print all words in order.
     */
    void showAllWords() {
        /* Message's length:012345678901234567890123456789*/
        System.out.println("NO   | English    | Vietnamese");
        /* Print out the English word and its Vietnamese translation */
        int a = dictionaryEng.printAll("", 0, 0);

        System.out.println("All available words have been displayed!");
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Print all the word with the beginning is part and meaning.
     */
    void dictionarySearcher(String part, DictChar dictionary) {
        DictChar fWord = dictionary.searchPart(part);
        if (fWord.getCharacter() == dictionary.getCharacter()) {
            System.out.println("No word found!");
        } else {
            System.out.println("Word have the same past you are searching for");
            if (dictionary == dictionaryEng) {
                System.out.println("NO   | English    | Vietnamese");
            } else {
                System.out.println("NO   | Vietnamese    | English");
            }
            fWord.printAll(part.substring(0,part.length() - 1), 0, 0);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    public String dictionaryLookupMean(String word) {
        return dictionaryEng.searchWord(word);
    }

    /**
     * Print the word user want and meaning.
     */
    void dictionaryLookup(String word, DictChar dictionary) {
        String pWord = dictionary.searchWord(word);
        if (pWord.equals("We can't find it!")) {
            System.out.println(pWord);
        } else {
            System.out.println("The word you are searching for: ");
            System.out.println(word  + " has the meaning: " + pWord);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Delete the given word.
     */
    void dictionaryDelete(String word, DictChar dictionary) {
        String mean = dictionary.searchWord(word);
        if (mean.equals("We can't find it!")) {
            System.out.println("This word does not exist!");
        } else {
            if (dictionary == dictionaryEng) {
                dictionaryEng.deleteWord(word);
                dictionaryVie.deleteWord(mean);
            } else {
                dictionaryEng.deleteWord(mean);
                dictionaryVie.deleteWord(word);
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Replace the old word pair by new word pair.
     */
    void dictionaryReplace(String wordEng, String wordVie) {
        String engMean = wordEng;
        String vieMean = wordVie;
        if (wordEng.equals("")) {
            engMean = dictionaryVie.searchWord(wordVie);
        } else if (wordVie.equals("")) {
            vieMean = dictionaryEng.searchWord(wordVie);
        }
        dictionaryEng.deleteWord(engMean);
        dictionaryVie.deleteWord(vieMean);
        dictionaryEng.addWord(engMean, vieMean);
        dictionaryVie.addWord(vieMean, engMean);
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Replace the meaning of the given word.
     */
    void dictionaryModMeaning(String word, String newMean, DictChar dictionary) {
        String oldMean = dictionary.searchWord(word);
        if (oldMean.equals("We can't find it!")) {
            System.out.println(oldMean);
        } else {
            if (dictionary == dictionaryEng) {
                dictionaryReplace(word, newMean);
            } else {
                dictionaryReplace(newMean, word);
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Replace the word but keep its meaning.
     */
    void dictionaryModWord(String word, String newWord, DictChar dictionary) {
        String mean = dictionary.searchWord(word);
        if (mean.equals("We can't find it!")) {
            System.out.println(mean);
        } else {
            if (dictionary == dictionaryEng) {
                dictionaryReplace(newWord, mean);
            } else {
                dictionaryReplace(mean, newWord);
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Insert from Command Line.
     */
    void insertFromCommandline() {
        /* Variables */
        Scanner sc = new Scanner(System.in);    // Using scanner to receive user inputs.
        int numberOfWords = -1;
        String wordEng;
        String wordVie;

        /* Input */
        while (numberOfWords < 0) {
            System.out.println("How many words are there?");
            System.out.print("(Input a non-negative number): ");
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
            dictionaryEng.addWord(wordEng, wordVie);
            dictionaryVie.addWord(wordVie, wordEng);

            --numberOfWords; // Reduce the number of Word in the queue by 1
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

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
            FileReader dictionaryFile = new FileReader("dictionaries.txt");

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

    /**
     * Export to file (output<outputDate>).
     * Thanks to: https://stackoverflow.com/a/6745127
     */
    void dictionaryExportToFile() throws IOException {
        // Output date
        Date today = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate= dateFormatter.format(today);
        String dictFileName = String.format("output%s.txt", strDate);

        BufferedWriter out = new BufferedWriter(new FileWriter(dictFileName));
        try {
            ArrayList<String> dictToFile = new ArrayList<>();
            int fillDict = dictionaryEng.dictToFileFiller(dictToFile, "", 0);
            String inputLine = null;
            int index = 0;
            do {
                inputLine = dictToFile.get(index);
                out.write(inputLine);
                out.newLine();
                ++index;
            } while (index < dictToFile.size());
        } catch(IOException e) {
            System.out.println("<!> Error during reading/writing <!>");
        } finally {
            out.close();
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------//

}

