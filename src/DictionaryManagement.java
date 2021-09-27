import java.io.*;
import java.nio.*;
import java.util.Scanner;

public class DictionaryManagement {
    /**
     * DictionaryManagement class - To insert new words to the dictionary from the CLI (command line interface).
     * More features (not bugs) will be implemented in the near future.
     */


    /** Variables. */
    Scanner sc = new Scanner(System.in);    // Using scanner to receive user inputs.

    /** Methods. */
    /* Insert From Command Line */
    void insertFromCommandline() {
        /* Variables */
        int numberOfWord = -1;
        int dictIndex = 0;
        String wordEn;
        String wordVie;

        /* Input */
        while (numberOfWord <= 0) {
            System.out.println("How many words are there?");
            System.out.print("(Input a positive number): ");
            numberOfWord = sc.nextInt();    // After using sc.nextInt(), we have to flush (?) the input stream
        }
        // Flushed!
        // Important variable meow~~
        String autoFlush = sc.nextLine();

        Dictionary.dictionary = new Word[numberOfWord];
        while (numberOfWord > 0) {
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
            --numberOfWord; // Reduce the number of Word in the queue by 1
        }
    }

    /* Insert From File */
    void insertFromFile() {
        try {
            // Open file
            File dictionaryFile = new File("src/dictionaries.txt");
            FileInputStream dictionaryFileStream = new FileInputStream(dictionaryFile);
            BufferedInputStream reader = new BufferedInputStream(dictionaryFileStream);

            // Number of Lines in file = Number of elements in Dictionary (array)
            int dictionarySize = numberOfLines(dictionaryFile);
            System.out.println(dictionarySize);

            // Close file
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
