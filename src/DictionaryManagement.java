/**
 * DictionaryManagement class - To insert new words to the dictionary from the CLI (command line interface).
 * More features (not bugs) will be implemented in the near future.
 */
import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {

    Character dictionary = new Character(' ', "");
    int numberOfWords = 0;
    /** Methods. *///-------------------------------------------------------------------------------------------------------------//

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
        int numberOfWords;
        int dictIndex = 0;
        String wordEng;
        String wordVie;
        String readLine;

        try {
            // Open file
            File dictionaryFile = new File("src/dictionaries.txt");

            // Number of Lines in file = Number of Words
            numberOfWords = numberOfLines(dictionaryFile);

            // Read file
            sc = new Scanner(dictionaryFile);

            // Imply that the input file is P E R F E C T
            while (sc.hasNextLine() && dictIndex < numberOfWords) {
                readLine = sc.nextLine();
                parser = new Scanner(readLine);
                parser.useDelimiter("\t");

                wordEng = parser.next();
                wordVie = parser.next();
//                Dictionary.dictionary[dictIndex] = new Word(wordEng, wordVie);

                dictionary.addWord(wordEng, wordVie);
                ++dictIndex;    // Increase the index of the Word array
            }

            // Close file (automated???)
        } catch (IOException e) {
            System.out.println("<!> Make sure you have dictionaries.txt in the src folder <!>");
//            e.printStackTrace();  for debugging
        }
    }

    static int numberOfLines(File file) throws IOException {
        FileReader readFile = new FileReader(file);
        LineNumberReader lineNumberReader = new LineNumberReader(readFile);

        int lineNumber = 0;
        while (lineNumberReader.readLine() != null) {
            lineNumber++;
        }
        return lineNumber;
    }

    /**
     * Testing methods.
     */
    void showAllWords() {
        /* Message's length:012345678901234567890123456789*/
        System.out.println("NO   | English    | Vietnamese");

        /* Print out the English word and its Vietnamese translation */
        int a = dictionary.printAll("", 0);
    }

    public static void main(String[] args) {
        Character test = new Character(' ', "");
        test.addWord("axe", "riu" );
        test.addWord("godgame", "tham tro choi" );
        test.addWord("god", "tham" );
        test.addWord("male", "nam" );
        test.addWord("female", "nu" );
        test.addWord("ass", "mong" );
        test.addWord("astroid", "thien thach" );
        test.addWord("as", "như là" );
        test.addWord("adudu", "adudu" );
        test.addWord("godfalse", "than sai cmnr" );
        test.addWord("godfall", "rot than" );
        test.addWord("goofy", "goofy" );
        test.printAll("", 0);
        System.out.println(test.searchWord("as"));
    }


}
