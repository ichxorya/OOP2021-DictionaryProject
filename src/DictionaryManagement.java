import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    /**
     * DictionaryManagement class - To insert new words to the dictionary from the CLI (command line interface).
     * More features (not bugs) will be implemented in the near future.
     */

    /** Methods. */
    /* Insert From Command Line */
    void insertFromCommandline() {
        /* Variables */
        Scanner sc = new Scanner(System.in);    // Using scanner to receive user inputs.
        int numberOfWords = -1;
        int dictIndex = 0;
        String wordEn;
        String wordVie;

        /* Input */
        while (numberOfWords <= 0) {
            System.out.println("How many words are there?");
            System.out.print("(Input a positive number): ");
            numberOfWords = sc.nextInt();    // After using sc.nextInt(), we have to flush (?) the input stream
        }
        // Flushed!
        // Important variable meow~~
        String autoFlush = sc.nextLine();

        Dictionary.dictionary = new Word[numberOfWords];
        while (numberOfWords > 0) {
            System.out.println("Input the English word and its Vietnamese translation: ");
            wordEn = sc.nextLine();
            wordVie = sc.nextLine();

            /* Non-empty check */
            while (wordEn.equals("")) {
                System.out.println("<!> Re-input the English word <!>");
                wordEn = sc.nextLine();
            }
            while (wordVie.equals("")) {
                System.out.println("<!> Re-input the Vietnamese translation <!>");
                wordVie = sc.nextLine();
            }

            /* Added to the dictionary */
            Dictionary.dictionary[dictIndex] = new Word(wordEn, wordVie);

            ++dictIndex;    // Increase the index of the Word array
            --numberOfWords; // Reduce the number of Word in the queue by 1
        }
    }

    /* Insert From File */
    void insertFromFile() {
        Scanner sc;    // Using scanner to receive data from external file.
        Scanner parser;    // Using scanner to parse strings from external file.
        int numberOfWords;
        int dictIndex = 0;
        String wordEn;
        String wordVie;
        String wordLine;

        try {
            // Open file
            File dictionaryFile = new File("src/dictionaries.txt");

            // Number of Lines in file = Number of Words
            numberOfWords = numberOfLines(dictionaryFile);
            Dictionary.dictionary = new Word[numberOfWords - 1];

            // Read file
            sc = new Scanner(dictionaryFile);

            // Imply that the input file is P E R F E C T
            while (sc.hasNextLine() && dictIndex < numberOfWords) {
                wordLine = sc.nextLine();
                parser = new Scanner(wordLine);
                parser.useDelimiter("\t");

                wordEn = sc.next();
                wordVie = sc.next();
                Dictionary.dictionary[dictIndex] = new Word(wordEn, wordVie);
//                System.out.println(wordEn + " " + wordVie);
                ++dictIndex;    // Increase the index of the Word array
            }

            // Close file (automated???)
        } catch (IOException e) {
            System.out.println("<!> Make sure you have dictionaries.txt in the src folder <!>");
//            e.printStackTrace();  for debugging
        }
    }

    static int numberOfLines(File file) throws IOException {
        FileReader fr = new FileReader(file);
        LineNumberReader lnr = new LineNumberReader(fr);

        int lineNumber = 0;
        while (lnr.readLine() != null) {
            lineNumber++;
        }
        return lineNumber;
    }
}
